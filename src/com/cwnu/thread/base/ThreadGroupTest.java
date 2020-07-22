package com.cwnu.thread.base;

/**
 * 线程组
 */
public class ThreadGroupTest implements Runnable {

    public static void main(String[] args) {
        ThreadGroup tg = new ThreadGroup("PrintGroup");
        Thread t1 = new Thread(tg, new ThreadGroupTest(), "T1");
        Thread t2 = new Thread(tg, new ThreadGroupTest(), "T2");
        t1.start();
        t2.start();
        System.out.println("ThreadGroup activeCount:" + tg.activeCount());
        tg.list();
    }

    @Override
    public void run() {
        String groupName = Thread.currentThread().getThreadGroup().getName() + "-" + Thread.currentThread().getName();
        while (true) {
            System.out.println("I am " + groupName);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
