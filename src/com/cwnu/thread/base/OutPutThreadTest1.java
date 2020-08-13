package com.cwnu.thread.base;

/**
 * 1-100，3个线程交替输出
 * synchronized实现方式
 */
public class OutPutThreadTest1 implements Runnable {
    private static Object lock = new Object();
    private static int count = 0;
    int no;
    public OutPutThreadTest1(int no) {
        this.no = no;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (count > 100) {
                    break;
                }
                if (count % 3 == this.no) {
                    System.out.println(this.no + "--->" + count);
                    count++;
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new OutPutThreadTest1(0));
        Thread t2 = new Thread(new OutPutThreadTest1(1));
        Thread t3 = new Thread(new OutPutThreadTest1(2));
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }
}
