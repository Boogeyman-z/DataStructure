package com.nfsq.linkedList;

/**
 * 双向链表
 */
public class TwoWayLinkedList {
    private Node head;//链表头
    private Node tail;//链表尾
    private int size;//节点数

    public class Node{
        private Node next;
        private Node pre;
        private Object data;

        public Node(Object obj) {
            this.data = obj;
        }
    }

    //在链表头增加节点
    public void addHead(Object value){
        Node node = new Node(value);
        if(size == 0){
            head = node;
            tail = node;
        }else{
            node.next = head;
            head.pre = node;
            head = node;
        }
        size++;
    }

    //在链表尾增加节点
    public void addTail(Object value){
        Node newNode = new Node(value);
        if(size == 0){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            newNode.pre = tail;
            tail = newNode;
        }
        size++;
    }


    //删除链表头
    public Node deleteHead(){
        Node temp = this.head;
        if(size != 0){
            head = head.next;
            head.pre = null;
            size--;
        }
        return temp;
    }

    //删除链表尾
    public Node deleteTail(){
        Node temp = this.tail;
        if(size != 0){
            tail = tail.next;
            tail.next = null;
            size--;
        }
        return temp;
    }

    //获得链表节点数
    public int getSize(){
        return size;
    }

    //判空
    public boolean isEmpty(){
        return (size == 0);
    }

    //显示节点信息
    public void display(){
        if(size > 0){
            Node node = this.head;
            int tempSize = this.size;
            if(tempSize == 1){
                System.out.println("["+node.data+"]");
                return;
            }
            while (tempSize > 0){
                if(node.equals(head)){
                    System.out.println("["+node.data+"->");
                }else if(node.next == null){
                    System.out.println(node.data+"]");
                }else{
                    System.out.println(node.data+"->");
                }
                node = node.next;
                tempSize--;
            }
            System.out.println();
        }else{
            System.out.println("[]");
        }
    }

}
