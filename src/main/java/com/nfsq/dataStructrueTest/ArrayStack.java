package com.nfsq.dataStructrueTest;

import org.junit.Test;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

public class ArrayStack {
    //存储元素的数组,声明为Object类型能存储任意类型的数据
    private Object[] elemObjects;

    //指向栈顶的指针
    private int top;

    //栈的总容量
    private int size;


    //默认构造一个容量为10的栈
    public ArrayStack() {
        this.size = 10;
        this.elemObjects = new Object[10];
        this.top = -1;
    }

    public ArrayStack(int initialCapacity){
        if(initialCapacity < 0){
            throw new IllegalArgumentException("栈初始化长度不能小于0："+initialCapacity);
        }
        this.elemObjects = new Object[initialCapacity];
        this.top = -1;
        this.size = initialCapacity;
    }

    //压入元素
    public Object push(Object item) {
        isGrow(top+1);
        elemObjects[++top] = item;
        return item;
    }

    //弹出栈顶元素
    public Object pop() {
        Object peek = peek();
        remove(top);
        return peek;
    }

    //获取栈顶元素
    public Object peek() {
        if(top == -1){
            throw new EmptyStackException();
        }
        return elemObjects[top];
    }

    //判断栈是否为空
    public boolean isEmpty() {
        return this.top == -1;
    }

    //删除栈顶元素
    public void remove(int top) {
        elemObjects[top] = null;
        this.top--;
    }

    /**
     * 是否需要扩容，如果需要，则扩大一倍并返回true，不需要则返回false
     *
     * @param minCapacity
     */
    public void isGrow(int minCapacity) {
        int oldCapacity = size;
        //如果当前元素压入栈之后总容量大于前面定义的容量，则需要扩容
        if(minCapacity >= oldCapacity){
            //定义扩大之后栈的总容量
            int newCapacity = 0;
            //栈容量扩大两倍(左移一位)看是否超过int类型所表示的最大范围
            if((oldCapacity<<1) - Integer.MAX_VALUE >0){
                newCapacity = Integer.MAX_VALUE;
            }else{
                newCapacity = (oldCapacity<<1);//左移一位，相当于*2
            }
            this.size = newCapacity;
            int[] newArray = new int[size];
            elemObjects = Arrays.copyOf(elemObjects, size);
        }else{
        }
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);
        stack.push(1);
        //System.out.println(stack.peek());
        stack.push(2);
        stack.push(3);
        stack.push("abc");
        System.out.println(stack.peek());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.peek());
    }


}
