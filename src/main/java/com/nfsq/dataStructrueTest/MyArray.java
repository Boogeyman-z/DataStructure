package com.nfsq.dataStructrueTest;

/**
 * @author Administrator
 */
public class MyArray {
    //定义一个数组
    private int [] intArray;

    //定义数组的实际有效长度
    private int elems;

    //定义数组的最大长度
    private int length;

    //默认构造一个长度为50的数组
    public MyArray(){
        elems = 0;
        length = 50;
        intArray = new int[length];
    }

    //构造函数，初始化一个长度为length 的数组.
    public MyArray(int length){
        elems = 0;
        this.length = length;
        intArray = new int[length];
    }


    //获取数组的有效长度
    public int getSize(){
        return elems;
    }

    /**
     * 遍历显示元素
     *
     */
    public void deploy(){
        for (int i = 0; i < elems; i++) {
            System.out.print(intArray[i]+" ");
        }
        System.out.println(" ");
    }

    /**
     * 添加元素
     */
    public boolean add(int value){
        if(elems == length){
            return false;
        }else{
            intArray[elems] = value;
            elems++;
        }
        return true;
    }

    //根据下标获取元素
    public int get(int i){
        if(i<0 || i>elems){
            System.out.println("IndexOutOfBound");
        }
        return intArray[i];
    }

    //查找元素 查找的元素如果存在则返回下标值，如果不存在，返回 -1
    public int find(int searchValue){
        int i;
        for (i = 0; i < elems; i++) {
            if(intArray[i]==searchValue){
                break;
            }
        }
        if(i==elems){
            return -1;
        }
        return i;
    }

    //删除元素 如果要删除的值不存在，直接返回 false;否则返回true，删除成功
    public boolean delete(int deleteValue){
        int result = find(deleteValue);
        if(result==-1){
            return false;
        }else{
            if(result==elems-1){
                elems--;
            }else{
                for (int i = result; i < elems - 1; i++) {
                    intArray[i] = intArray[i+1];
                }
                elems--;
            }
            return true;
        }
    }

    //修改数据 修改成功返回true，修改失败返回false
    public boolean modify(int oldValue,int newValue){
        int index = find(oldValue);
        if(index == -1){
            System.out.println("修改数据不存在");
            return false;
        }else{
            intArray[index] = newValue;
            return true;
        }
    }



}
