package com.cwnu.base.genericity;

public class GenericityMethod {

    /**
     * 泛型方法可以在普通类中定义
     * @param a
     * @param <T>
     * @return
     */
    public static <T> T getValue(T... a){
        return a[a.length /2];
    }
}
