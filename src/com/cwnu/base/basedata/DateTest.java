package com.cwnu.base.basedata;

import java.math.BigInteger;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.concurrent.CountDownLatch;

public class DateTest {


    public static void main(String[] args) {
//        int year = 2019;
//        LocalDate localDate = LocalDate.of(year,1,1);
//        System.out.println(localDate.toString());

//        Date date = new Date(1609430400000L);
//        System.out.println(date);

//        long start = System.currentTimeMillis();
//        Date date = new Date();
//        long end = System.currentTimeMillis();
//        System.out.println(end- start);
        int i = 1;
        int n = 100;
        for(;i<=n;i++){
            System.out.println("i:" + i);
        }

        BigInteger bigInteger = BigInteger.valueOf(111L);
        bigInteger.longValue();
    }
}
