package com.nfsq.linkedList;

public class SingleLinkedListTest {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addHead("A");
        singleLinkedList.addHead("B");
        singleLinkedList.addHead("C");
        singleLinkedList.addHead("D");
        //打印
        singleLinkedList.display();
        //删除C
        singleLinkedList.delete("C");
        singleLinkedList.display();
        //查找B
        System.out.println(singleLinkedList.find("B"));
    }

}
