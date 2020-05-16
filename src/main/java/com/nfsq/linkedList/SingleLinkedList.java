package com.nfsq.linkedList;


import javax.xml.soap.Node;

public class SingleLinkedList {
    private int size;//链表节点的个数
    private Node head;//头结点

    public SingleLinkedList() {
        size = 0;
        head = null;
    }

    //链表每个节点类
    public class Node {
        private Object data;//每个节点的数据
        private Node next;//每个节点指向下一个节点的连接

        public Node(Object obj) {
            this.data = obj;
        }
    }

    //头结点添加元素
    public Object addHead(Object obj) {
        Node newHead = new Node(obj);
        if (size == 0) {
            head = newHead;
        } else {
            newHead.next = head;
            head = newHead;
        }
        size++;
        return obj;
    }

    //在链表头删除元素
    public Object deleteHead() {
        if(size == 0){
            return null;
        }
        Object data = head.data;
        head = head.next;
        size--;
        return data;
    }

    //查找指定元素，找到了返回节点Node，找不到返回null
    public Node find(Object obj) {
        Node currentNode = this.head;
        int tempSize = this.size;
        while (tempSize > 0) {
            if (obj.equals(currentNode.data)) {
                return currentNode;
            } else {
                currentNode = currentNode.next;
            }
            tempSize--;
        }
        return null;
    }

    //删除指定的元素，删除成功返回true
    public boolean delete(Object obj) {
        if (size == 0) {
            return false;
        }
        Node current = this.head;
        Node previous = this.head;

        //找到需要删除的节点和他下一个节点
        while (!obj.equals(current.data)) {
            if (current.next == null) {
                return false;
            } else {
                previous = current;
                current = current.next;
            }
        }

        //需要删除的是第一个节点
        if (head == current) {
            head = head.next;
        } else {
            previous.next = current.next;
        }
        size--;
        return true;
    }

    //判断链表是否为空
    public boolean isEmpty() {
        return (size == 0);
    }

    //显示节点信息
    public void display() {
        if (size > 0) {
            Node node = this.head;
            int tempSize = this.size;
            //当前链表只有一个节点
            if (tempSize == 1) {
                System.out.print("[" + node.data + "]");
                return;
            }

            while (tempSize > 0) {
                if (node.equals(head)) {
                    System.out.print("[" + node.data + "->");
                } else if (node.next == null) {
                    System.out.print(node.data + "]");
                } else {
                    System.out.print(node.data + "->");
                }
                node = node.next;
                tempSize--;
            }
            System.out.println();
        } else {
            //如果链表一个节点都没有，直接打印[]
            System.out.println("[]");
        }
    }
}
