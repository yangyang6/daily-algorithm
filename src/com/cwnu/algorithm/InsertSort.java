package com.cwnu.algorithm;


import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] a = {5, 4, 3, 2, 1};
        for (int i = 0, j = i; i < a.length - 1; j = ++i) {
            int ai = a[i + 1];
            while (ai < a[j]) {
                a[j + 1] = a[j];
                if (j-- == 0) {
                    break;
                }
            }
            a[j + 1] = ai;
        }

        for (int b : a) {
            System.out.println(b);
        }
    }
}
