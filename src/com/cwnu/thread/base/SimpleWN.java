package com.cwnu.thread.base;

public class SimpleWN {

    final static Object object = new Object();

    public static class T1 extends Thread {
        @Override
        public void run() {
            //申请object对象
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ": t1 start");

                System.out.println(System.currentTimeMillis() + ": t1 wait");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ": t1 end");
            }
        }
    }
}
