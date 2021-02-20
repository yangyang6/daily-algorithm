package com.cwnu.base;

import java.util.ArrayList;

public class Test3 {
    public static void main(String[] args) {
        /**
         * == 比较的是内存地址
         * equals 是比较的值
         */
        Integer aa = 1111;
        Integer bb = new Integer(1111);
        System.out.println(aa == bb);

        System.out.println(aa.intValue() == bb.intValue());

        new ArrayList();
    }
}
