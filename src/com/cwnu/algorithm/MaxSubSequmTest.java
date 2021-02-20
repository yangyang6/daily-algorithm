package com.cwnu.algorithm;

public class MaxSubSequmTest {
    static int MaxSubSequm1(int A[], int N) {
        int ThisSum, MaxSum = 0;
        int i, j, k;
        for (i = 0; i < N; i++) {  // i 是子列左端的位置
            for (j = i; j < N; j++) { //j 是子列右端的位置
                ThisSum = 0;               //*
                for (k = i; k <= j; k++)   //*
                    ThisSum += A[k];       //*
                if (ThisSum > MaxSum)  // 如果刚得到的子列和更大
                    MaxSum = ThisSum; // 更新结果

            }

        }// 循环结束
        return MaxSum;
    }

    public static void main(String[] args) {
        int[] a = {-2,11,-4,13,-5,-2};
        System.out.println(MaxSubSequm1(a,a.length));
    }
}
