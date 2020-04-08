package com.cwnu.thread.reentrant;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 中断响应
 * 再等待锁的过程中，需要取消对锁的请求
 */
public class IntLock implements Runnable{

    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();

    int lock;

    /**
     * 控制加锁顺序，方便构造死锁
     * @param lock
     */
    public IntLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            if(lock == 1){
                lock1.lockInterruptibly();
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){ }
                lock2.lockInterruptibly();
                System.out.println("11111");
            }else {
                lock2.lockInterruptibly();
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){ }
                lock1.lockInterruptibly();
                System.out.println("22222");
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            if(lock1.isHeldByCurrentThread()){
                lock1.unlock();
            }
            if(lock2.isHeldByCurrentThread()){
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getName() + "线程退出");
        }
    }

    public static void main(String[] args) throws InterruptedException{
        IntLock r1 = new IntLock(1);
        IntLock r2 = new IntLock(2);
        Thread t1 = new Thread(r1);
        t1.setName("thread t1");
        Thread t2 = new Thread(r2);
        t2.setName("thread t2");
        t1.start(); t2.start();
        Thread.sleep(1000);
        t2.interrupt();
    }
}
