package com.cwnu.thread.base;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {
    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();
                System.out.println(2);
                c.countDown();
                while (true){
                    //
                    System.out.println("aaaa");
                }
            }
        }).start();

        //还可以指定主线程等待的时长
        c.await(1, TimeUnit.SECONDS);
        System.out.println("3");
    }
}
