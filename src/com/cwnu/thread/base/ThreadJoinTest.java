package com.cwnu.thread.base;

/**
 * join - Waits for this thread to die.
 * 实现线程的执行顺序 t1 -> t2 -> t3
 */
public class ThreadJoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread("thread-1") {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };


        Thread t2 = new Thread("thread-2") {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };


        Thread t3 = new Thread("thread-3") {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };

        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
    }
}
