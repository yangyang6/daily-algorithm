package com.cwnu.designpattern.proxy;

public class Star implements IAct {
    public void doSing() {
        System.out.println("唱歌");
    }

    public void doDance() {
        System.out.println("跳舞");
    }
}
