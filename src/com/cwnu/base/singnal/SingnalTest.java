package com.cwnu.base.singnal;

import sun.misc.Signal;
import sun.misc.SignalHandler;

import java.util.ArrayList;
import java.util.List;

public class SingnalTest {
    public static void main(String[] args) throws InterruptedException{

        Signal.handle(new Signal("INT"), new SignalHandler() {
            @Override
            public void handle(Signal signal) {
                System.out.println(signal.toString() + " cached");
            }
        });

        /**
         * Linux/Unit teminal就是调的这个
         */
        Signal.handle(new Signal("TERM"), new SignalHandler() {
            @Override
            public void handle(Signal signal) {
                System.out.println(signal.toString() + " cached");
            }
        });


        while(true){
            Thread.sleep(1000);
            System.out.println(123);
        }




    }
}
