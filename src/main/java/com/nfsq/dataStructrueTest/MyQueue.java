package com.nfsq.dataStructrueTest;

/**
 * 模拟单向队列
 * @author Administrator
 */
public class MyQueue {
    private Object[] queArray;
    //队列大小
    private int maxSize;
    //前端
    private int front;
    //后端
    private int rear;
    //队列中元素的实际数量
    private int nItems;

    public MyQueue(int s){
        maxSize = s;
        queArray = new Object[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    //队列新增数据
        public void insert(Object value){
            if(isFull()){
                System.out.println("队列已满！！！");
            }else{
                //如果队列尾部指向顶了，那么循环回来，执行队列的第一个元素
                if(rear == maxSize -1){
                    rear = -1;
                }
                //队尾指针加1，然后在队尾指针处插入新的数据
                queArray[++rear] = value;
                nItems++;
            }
    }

    //移除数据
    public Object remove(){
        Object removeValue = null;
        if(!isEmpty()){
            removeValue = queArray[front];
            queArray[front] = null;
            front++;
            if(front == maxSize){
                front = 0;
            }
            nItems--;
        }
        return removeValue;
    }



    //查看对象头数据
    public Object peekFront(){
        return queArray[front];
    }

    //判断队列是否满了
    public boolean isFull(){
        return nItems == maxSize;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return nItems == 0;
    }

    //返回队列大小
    public int getSize(){
        return nItems;
    }

}

