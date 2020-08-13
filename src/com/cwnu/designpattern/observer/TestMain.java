package com.cwnu.designpattern.observer;

import java.util.concurrent.locks.Lock;

public class TestMain {
    public static void main(String[] args) {
        HeadCounter headCounter = new HeadCounter();
        //注册订阅者
        headCounter.registerObserver(new JobSeeker("Mike"));
        headCounter.registerObserver(new JobSeeker("Chris"));
        headCounter.registerObserver(new JobSeeker("Jeff"));
        //通知所有订阅者有新的工作机会
        headCounter.addJob("Google Job");
        headCounter.addJob("Yahoo Job");

        Integer t = null;
        int m = t;
        System.out.println(t);
    }
}
