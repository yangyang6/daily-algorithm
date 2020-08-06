package com.cwnu.thread.base;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class ThreadPoolTest {
    private static final AtomicInteger FINISH_COUNT = new AtomicInteger(0);

    private static final AtomicLong COST = new AtomicLong(0);

    private static final Integer INCREASE_COUNT = 1000000;

    private static final Integer TASK_COUNT = 1000;


    public static void main(String[] args) {

        //thread pool method
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(100, 100, 0, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
//        for(int i=0;i<TASK_COUNT;i++){
//            executor.submit(new IncreaseThread());
//        }

        List<Thread> tList = new ArrayList<>(TASK_COUNT);
        for (int i = 0; i < TASK_COUNT; i++) {
            tList.add(new Thread(new IncreaseThread()));
        }

        for (Thread t : tList) {
            t.start();
        }


        for (; ; ) ;
    }


    private static class IncreaseThread implements Runnable {
        @Override
        public void run() {
            long startTime = System.currentTimeMillis();

            AtomicInteger counter = new AtomicInteger(0);
            for (int i = 0; i < INCREASE_COUNT; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + counter.get());
                counter.incrementAndGet();
            }

            COST.addAndGet(System.currentTimeMillis() - startTime);
            if (FINISH_COUNT.incrementAndGet() == TASK_COUNT) {
                System.out.println("cost:" + COST.get() + "ms");
            }
        }
    }
}
