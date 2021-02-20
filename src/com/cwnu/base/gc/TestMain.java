package com.cwnu.base.gc;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TestMain {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a.setB(b);
        b.setA(a);

        a = null;
        b = null;


        System.gc();


        String str1 = "abc";
        String str2 = "abc";
        System.out.println(str1 == str2);
    }
}
