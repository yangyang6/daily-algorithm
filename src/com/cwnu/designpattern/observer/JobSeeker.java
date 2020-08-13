package com.cwnu.designpattern.observer;

public class JobSeeker implements Observer{
    private String name;

    public JobSeeker(String name){
        this.name = name;
    }

    @Override
    public void update(Subject subject) {
        System.out.println(this.name + " got notified!");
        System.out.println(subject);
    }
}
