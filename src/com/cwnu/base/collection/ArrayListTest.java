package com.cwnu.base.collection;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
//        ArrayList users = new ArrayList(10000);
//        for (int i = 0; i < 10000; ++i) { users.add(i);}
//        long end = System.currentTimeMillis();
//        System.out.println("end - start:" + (end - start));



        long start = System.nanoTime();
        ArrayList<Integer> users = new ArrayList<>();
        for (int i = 0; i < 10000; ++i) { users.add(i);}
        long end = System.nanoTime();
        System.out.println("end - start:" + (end - start));


        //使用数组进行简单的存储运算只需要一半的时间
//        long start = System.nanoTime();
//        int[] intArray = new int[10000];
//        for (int i = 0; i < 10000; ++i) {
//            intArray[i] = i;
//        }
//        long end = System.nanoTime();
//        System.out.println("end - start:" + (end - start));
    }
}
