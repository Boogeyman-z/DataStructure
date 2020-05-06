package com.nfsq.test;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @author Administrator
 */
public class BloomFilterTest {

    /**
     * 预计要插入的数据
     */
    private static int size = 1000000;

    private static double fpp = 0.01;

    private static BloomFilter<Integer> booleanFilter = BloomFilter.create(Funnels.integerFunnel(),size,fpp);

    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            booleanFilter.put(i);
        }
        int count = 0;
        for (int i = 1000000; i < 2000000; i++) {
            if(booleanFilter.mightContain(i)){
                count++;
                System.out.println(i+"误判了！");
            }
        }
        System.out.println("误判了"+count+"次");
    }


}
