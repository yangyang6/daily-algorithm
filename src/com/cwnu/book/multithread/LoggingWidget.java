package com.cwnu.book.multithread;

public class LoggingWidget extends Widget{
    @Override
    public synchronized void doSomething() {
        System.out.println(toString() + ": calling doSomething");
        super.doSomething();
    }
}

class Widget{
    public synchronized void doSomething(){
    }
}