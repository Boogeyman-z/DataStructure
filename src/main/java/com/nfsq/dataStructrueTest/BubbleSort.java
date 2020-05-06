package com.nfsq.dataStructrueTest;

public class BubbleSort {
    public static int[] sort(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[i]>array[j]){
                    int count = array[i];
                    array[i] = array[j];
                    array[j] = count;
                }
            }
            System.out.println("第"+i+"次排序");
            DisplayUtil.display(array);
        }
        System.out.println("排序后：");
        DisplayUtil.display(array);
        return array;
    }

    public static void main(String[] args) {
        int[] array = {4,2,8,9,5,7,6,1,3};
        sort(array);
    }
}
