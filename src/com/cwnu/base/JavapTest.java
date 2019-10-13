package com.cwnu.base;

/**
 * Created by rey on 2019-10-12.
 */
public class JavapTest {
    public static void main(String[] args) {
        int a = 8;
        //注意观察这个class 字节码分析情况
        a = a++;
        System.out.println(a);
    }
}
