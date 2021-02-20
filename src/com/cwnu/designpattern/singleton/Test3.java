package com.cwnu.designpattern.singleton;

/**
 * 双重校验锁
 * 当遇到高并发情况，会出现因"指令重排"导致拿到的对象为空的情况
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
