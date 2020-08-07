package com.cwnu.thread.reentrant;

import java.util.concurrent.locks.ReentrantLock;

public class ReenternLockTest implements Runnable {

    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 1000; j++) {
            lock.lock();

            try {
                i++;
                System.out.println("This current thread:" + Thread.currentThread().getName() + " and i:" + i);
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenternLockTest t = new ReenternLockTest();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("i:" + i);
    }
}
