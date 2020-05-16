package com.nfsq.linkedList;

/**
 * 双端链表
 */
public class DoublePointLinkedList {
    private Node head;//头节点
    private Node tail;//尾节点
    private int size;//节点数


    private class Node {
        private Object obj;
        private Node next;

        private Node(Object data) {
            obj = data;
        }
    }

    public DoublePointLinkedList() {
        size = 0;
        tail = null;
        head = null;
    }

    //链表头新增节点
    public void addHead(Object data) {
        Node node = new Node(data);
        //如果链表为空，那么头节点和尾节点都是该新增节点
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            node.next = head;
        }
        size++;
    }

    //链表尾新增节点
    public void addTail(Object data) {
        Node node = new Node(data);
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    //删除头部节点，成功返回true，失败返回false
    public boolean deleteHead() {
        if (size == 0) {
            return false;
        }else{
            //只有一个节点时
            if(head.next==null){
                head = null;
                tail = null;
            }else{
                head = head.next;
            }
        }
        size--;
        return true;
    }

    //判空
    public boolean isEmpty(){
        return (size == 0);
    }

    //获取链表节点数
    public int getSize(){
        return size;
    }

    //显示节点信息
    public void display(){
        if(size > 0 ){
            Node node = this.head;
            int tempSize = this.size;
            if(tempSize == 1){
                System.out.println("["+ node.obj+"]");
                return;
            }
            while (tempSize > 0){
                if(node.equals(head)){
                    System.out.print("["+node.obj+"->");
                }else if(node.next == null){
                    System.out.print(node.obj + "]");
                }else{
                    System.out.println(node.obj + "->");
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
