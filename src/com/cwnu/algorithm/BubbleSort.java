package com.cwnu.algorithm;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[]{1, 6, 3, 2, 1, 7, 3, 2};
        //外层循环控制排序趟数
        for (int i = 0; i < array.length - 1; i++) {
            //内层循环控制每一趟排序的次数
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        for (int a : array) {
            System.out.println(a);
        }
    }
}
