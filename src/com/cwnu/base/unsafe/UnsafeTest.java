package com.cwnu.base.unsafe;

import sun.misc.Unsafe;


public class UnsafeTest {


    public static void main(String[] args) throws Exception{
       Class<?> clazz = ObjectA.class.getClass();
       Unsafe unsafe = Unsafe.getUnsafe();
       long d =  unsafe.objectFieldOffset(clazz.getDeclaredField("a"));
       System.out.println(d);
    }
}
