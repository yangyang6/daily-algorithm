package com.cwnu.designpattern.singleton;

/**
 * 先写一个最简单的单例模式吧
 * 饿汉式
 */
public class Test1 {

    private static Object object = new Object();

    /**
     * 私有化构造方法
     */
    private Test1(){}

    public static Object newObject(){
        return object;
    }
}
