package com.cwnu.designpattern.singleton;

/**
 * 双重校验锁
 */
public class Test3 {
    private static Object object;

    private Test3(){}

    public static Object newObject(){
        if(object == null){
            synchronized (Test3.class){
                if(object == null){
                    object = new Object();
                }
            }
        }
        return object;
    }
}
