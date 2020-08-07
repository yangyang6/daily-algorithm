package com.cwnu.thread.base;


import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class InitThreadTest {
    static class Thread1 extends Thread{
        @Override
        public void run() {
            System.out.println("Thread1 running...");
        }
    }

    static class Thread2 implements Runnable{
        @Override
        public void run() {
            System.out.println("Thread2 running...");
        }
    }

    static class Thread3<T> implements Callable<T> {
        @SuppressWarnings("unchecked")
        @Override
        public T call() throws Exception {
            System.out.println("Thread3 running...");
            return (T)new String("aaa");
        }
    }

    public static void main(String[] args) throws Exception{
        Thread1 t1 = new Thread1();
        Thread t2 = new Thread(new Thread2());

        FutureTask<String> ft = new FutureTask<>(new Thread3<>());
        Thread t3 = new Thread(ft);

        t1.start();
        t2.start();
        t3.start();

        System.out.println(ft.get());
    }
}


