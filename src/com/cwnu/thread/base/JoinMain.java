package com.cwnu.thread.base;

public class JoinMain {

    public volatile static int i = 0;

    public static class AddThread extends Thread {
        @Override
        public void run() {
            for (i = 0; i < 10000; i++) ;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AddThread addThread = new AddThread();
        addThread.start();

        //join方法本质是让调用线程wait()方法在当前线程对象实例上
        addThread.join();


        System.out.println(i);
    }
}
