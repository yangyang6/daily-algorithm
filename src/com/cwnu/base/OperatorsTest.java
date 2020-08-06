package com.cwnu.base;

public class OperatorsTest {
    public static void main(String[] args) {
        int var1 = 5;
        int var2 = 6;
        int var3;
        // 5 * 6 / 6 + 6
        int var4 = var1++ * var2 / var1;
        var3 = var1++ * var2 / var1 + var2;
        System.out.println(var1);
        System.out.println(var3);
        System.out.println(var4);
    }
}
