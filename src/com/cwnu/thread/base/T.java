package com.cwnu.thread.base;

public class T {

    private static Object object = new Object();

    public static void main(String[] args) {
        synchronized (object){
            System.out.println("aaa");
        }
    }
}
