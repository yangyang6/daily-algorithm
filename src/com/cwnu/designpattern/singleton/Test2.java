package com.cwnu.designpattern.singleton;

/**
 * 懒汉式
 */
public class Test2 {
    private static Object object;

    /**
     * 私有化构造方法
     */
    private Test2(){}

    public static Object newObject(){
        if(object == null){
            object = new Object();
        }
        return object;
    }
}
