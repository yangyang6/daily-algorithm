package com.cwnu.thread.base;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Customer implements Runnable {

    private Semaphore washbasin;
    private String name;

    public Customer(Semaphore washbasin, String name) {
        this.washbasin = washbasin;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
            Random random = new Random();

            washbasin.acquire();
            System.out.println(sdf.format(new Date()) + " " + name + "开始洗手");
            Thread.sleep((long) (random.nextDouble() * 5000) + 2000);
            System.out.println(sdf.format(new Date()) + " " + name + "洗手完毕");
            washbasin.release();
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Semaphore washbasin = new Semaphore(2);

        List<Thread> threadList = new ArrayList<>(3);
        threadList.add(new Thread(new Customer(washbasin, "张三")));
        threadList.add(new Thread(new Customer(washbasin, "李四")));
        threadList.add(new Thread(new Customer(washbasin, "王五")));
        threadList.add(new Thread(new Customer(washbasin, "赵六")));
        for (Thread thread : threadList) {
            thread.start();
            Thread.sleep(50);
        }

        for (Thread thread : threadList) {
            thread.join();
        }

    }
}
