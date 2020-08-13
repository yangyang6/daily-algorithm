package com.cwnu.thread.base;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  1-100，3个线程交替输出
 *  可重入锁的方式
 */
public class OutPutThreadTest2 implements Runnable {
    private int no;

    private static ReentrantLock lock = new ReentrantLock();

    private static Condition condition = lock.newCondition();

    private static int count;

    public OutPutThreadTest2(int no) {
        this.no = no;
    }


    @Override
    public void run() {
        while (true) {
            lock.lock();
            if (count > 100) {
                break;
            } else {
                if (count % 3 == this.no) {
                    System.out.println(this.no + "-->" + count);
                    count++;
                } else {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            condition.signalAll();
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new OutPutThreadTest2(0));
        Thread t2 = new Thread(new OutPutThreadTest2(1));
        Thread t3 = new Thread(new OutPutThreadTest2(2));
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }
}
