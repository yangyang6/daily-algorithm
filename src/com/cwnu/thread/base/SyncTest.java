package com.cwnu.thread.base;

public class SyncTest {

    private Object obj = new Object();

    public synchronized void synchronizedMethod() {
        System.out.println("begin");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finish calling");
    }

    public void generalMethod() {
        System.out.println("call general");
    }

    public static void main(String[] args) {
        SyncTest syncTest = new SyncTest();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                syncTest.synchronizedMethod();
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                syncTest.generalMethod();
            }
        };

        t1.start();
        t2.start();
    }
}
