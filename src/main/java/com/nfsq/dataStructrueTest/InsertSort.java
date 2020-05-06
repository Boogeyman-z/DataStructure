package com.nfsq.dataStructrueTest;

public class InsertSort {
    public static int[] sort(int[] array){
        int j;
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            j = i;
            while (j > 0 && temp < array[j - 1]){
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
            System.out.println("第"+i+"次");

            DisplayUtil.display(array);
        }
        return array;
    }


    public static void main(String[] args) {
        int[] array = {4,2,8,9,5,7,6,1,3};
        //未排序数组顺序为
        System.out.println("未排序数组顺序为：");
        DisplayUtil.display(array);
        System.out.println("-----------------------");
        array = sort(array);
        System.out.println("-----------------------");
        System.out.println("经过插入排序后的数组顺序为：");
        DisplayUtil.display(array);
    }

}
