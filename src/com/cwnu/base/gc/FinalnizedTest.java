package com.cwnu.base.gc;

import java.util.ArrayList;

public class FinalnizedTest {
    public static void main(String[] args) {
        for(int i=0;i<4;i++){
            new FinalnizedTest();

            //建议JVM垃圾回收期进行回收
            System.gc();
        }

        System.out.println(10>>1);
        //ArrayList
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("aaa");
    }
}
