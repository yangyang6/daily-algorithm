package com.cwnu.designpattern.singleton;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 主Test方法
 */
public class Test {
    public static void main(String[] args) {
//        Test1 test1 = new Test1();
//        Object obj1 = test1.newObject();
//        Object obj2 = test1.newObject();
//        System.out.println(obj1 == obj2);

//        Object obj1 = Test2.newObject();
//        Object obj2 = Test2.newObject();
//        System.out.println(obj1 == obj2);

//        Object obj1 = Test3.newObject();
//        Object obj2 = Test3.newObject();
//        System.out.println(obj1 == obj2);


        Test4 obj1 = Test4.INSTANCE;
        Test4 obj2 = Test4.INSTANCE;
        System.out.println(obj1 == obj2);
    }
}
