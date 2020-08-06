package com.cwnu.thread.base;

public class GoodSuspend {

    public static Object u = new Object();

    public static class ChangeObjectThread extends Thread{
        //标识当前线程是否挂起
        volatile boolean suspendMe = false;

        //挂起线程的方法
        public void suspendMe(){
            suspendMe = true;
        }

        //继续执行线程的方法
        public void resumeMe(){
            suspendMe = false;

            synchronized (this){
                notify();
            }
        }

        @Override
        public void run() {
            while (true){
                synchronized (this){
                    while (suspendMe){
                        try{
                            wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }

                synchronized (u){
                    System.out.println("in ChangeObject Thread");
                }

                Thread.yield();
            }
        }
    }

    public static class ReadObjectThread extends Thread{
        @Override
        public void run() {
            while (true){
                synchronized (u){
                    System.out.println("in ReadObjectThread");
                }

                //谦让
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws Exception{
        ChangeObjectThread t1 = new ChangeObjectThread();
        ReadObjectThread t2 = new ReadObjectThread();
        t1.start();
        t2.start();
        Thread.sleep(100);

        t1.suspendMe();
        System.out.println("t1 suspendMe 2 sec");
        Thread.sleep(100000);
        System.out.println("resume t1");
        t1.resumeMe();
    }
}
