package com.cwnu.thread.reentrant;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 限时等待
 */
public class TimeLock implements Runnable{

    public static ReentrantLock lock = new ReentrantLock();

    /**
     * t1线程占用锁时间为6s
     * t2线程tryLock在5s等待获取锁不到的情况下，走else通道
     */
    @Override
    public void run() {
        try{
            if(lock.tryLock(5, TimeUnit.SECONDS)){
                System.out.println(Thread.currentThread().getName() + "线程睡眠前");
                Thread.sleep(6000);
                System.out.println(Thread.currentThread().getName() + "线程睡眠后");
            }else {
                System.out.println(Thread.currentThread().getName() + "线程");
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            if(lock.isHeldByCurrentThread()){
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        TimeLock tl = new TimeLock();
        Thread t1 = new Thread(tl);
        t1.setName("t1");
        Thread t2 = new Thread(tl);
        t2.setName("t2");
        t1.start();
        t2.start();
    }
}
