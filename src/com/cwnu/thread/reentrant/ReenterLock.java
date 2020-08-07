package com.cwnu.thread.reentrant;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁
 * 开发人员必须手动指定何时加锁，何时释放锁，重入锁逻辑控制的灵活性要远远优于synronized
 * 重入锁还提供一些高级功能 如中断处理的能力
 */
public class ReenterLock implements Runnable {

    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
            lock.lock();
            try {
                i++;
            } finally {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ReenterLock reenterLock = new ReenterLock();
        Thread t1 = new Thread(reenterLock);
        Thread t2 = new Thread(reenterLock);

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
