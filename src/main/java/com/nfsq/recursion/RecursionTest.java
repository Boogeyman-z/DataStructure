package com.nfsq.recursion;

import java.util.Arrays;

public class RecursionTest {

    /**
     * 汉诺塔问题
     *
     * @param dish 盘子数量
     * @param from 初始塔座
     * @param temp 中介塔座
     * @param to   目标塔座
     */
    public static void move(int dish, String from, String temp, String to) {
        if (dish == 1) {
            System.out.println("将盘子" + dish + "从塔座" + from + "移至目标塔座" + to);
        } else {
            //A为初始塔座，B为目标塔座，C为中介塔座
            move(dish - 1, from, to, temp);
            System.out.println("将盘子" + dish + "从塔座" + from + "移动到目标塔座" + to);
            //B为初始塔座，C为目标塔座，A为中介塔座
            move(dish - 1, temp, from, to);
        }
    }

    public static void main(String[] args) {
//        move(3,"A","B","C");
        int[] c = {2, 7, 8, 3, 1, 6, 9, 0, 5, 4};
        c = mergeSort(c, 0, c.length - 1);
        System.out.println(Arrays.toString(c));
    }


    /**
     * 传入有序的两个数组a,b，返回排好序的合并数组
     *
     * @param a
     * @param b
     * @return
     */
    public static int[] sort(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int aNum = 0, bNum = 0, cNum = 0;
        while (aNum < a.length && bNum < b.length) {
            //比较a数组和b数组大小
            if (a[aNum] > b[bNum]) {
                c[cNum++] = b[bNum++];
            } else {
                c[cNum++] = a[aNum++];
            }
        }

        //如果a数组全部赋值到c数组了，但是b数组还有元素，则将b数组剩余元素按顺序全部复制到c数组
        while (aNum == a.length && bNum < b.length) {
            c[cNum++] = b[bNum++];
        }

        //如果b数组全部赋值到c数组了，但是a数组还有元素，则将a数组剩余元素按顺序全部复制到c数组
        while (bNum == b.length && aNum < a.length) {
            c[cNum++] = a[aNum++];
        }

        return c;
    }


    public static int[] mergeSort(int[] c, int start, int last) {
        if (last > start) {
            int mid = start + (last - start) / 2;
            //左边数组排序
            mergeSort(c, start, mid);
            //右边数组排序
            mergeSort(c, mid + 1, last);
            //右边数组排序
            merge(c, start, mid, last);
        }
        return c;
    }

    public static void merge(int[] c, int start, int mid, int last) {
        //定义临时数组
        int[] temp = new int[last - start + 1];
        //定义左边数组的下标
        int i = start;
        //定义右边数组的下标
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= last) {
            if (c[i] < c[j]) {
                temp[k++] = c[i++];
            } else {
                temp[k++] = c[j++];
            }
        }
        //把左边剩余数组元素移入新数组中
        while (i <= mid) {
            temp[k++] = c[i++];
        }
        //把右边剩余数组元素移入到新数组中
        while (j <= last) {
            temp[k++] = c[j++];
        }

        //把新数组中的数覆盖到c数组中
        for (int z = 0; z < temp.length; z++) {
            c[z + start] = temp[z];
        }

    }


    /**
     * 求一个数的乘方
     *
     * @param x
     * @param y
     * @return
     */
    public static int power(int x, int y) {
        if (x == 0 || x == 1) {
            return x;
        }
        if (y > 1) {
            int a = y / 2;
            int b = x * x;
            return power(a, b);
        } else if (y == 0) {
            return 1;
        } else {
            return x;
        }
    }


}
