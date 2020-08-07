package com.cwnu.thread.base;


/**
 * 线程优先级
 * 分为1-10的数值，数值越大优先级越高
 * synchronized关键字确保线程同步和安全性，还能保证线程间的可见性和有序性
 * 优先级的定义感觉不是完全准确
 */
public class PriorityDemo {
    static class HighProperty extends Thread {
        static int count = 0;

        @Override
        public void run() {
            while (true) {
                synchronized (PriorityDemo.class) {
                    count++;
                }

                System.out.println("high i:" + count);
                if (count == 99) {
                    System.out.println("HighProperty count is max");
                    break;
                }
            }
        }
    }

    static class LowerProperty extends Thread {
        static int count = 0;

        @Override
        public void run() {
            while (true) {
                synchronized (PriorityDemo.class) {
                    count++;
                }

                System.out.println("low i:" + count);
                if (count == 99) {
                    System.out.println("LowerProperty count is max");
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread high = new HighProperty();
        Thread lower = new LowerProperty();
        high.setPriority(Thread.MAX_PRIORITY);
        lower.setPriority(Thread.MIN_PRIORITY);
        high.start();
        lower.start();
    }
}
