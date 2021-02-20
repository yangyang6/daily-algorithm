package com.cwnu.base;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * LocalDateTime 相当于 LocalDate（日期处理类） 和 LocalTime（时间处理类）
 */
public class LocalDateTimeTest {
    public static void main(String[] args) throws Exception{
        // 获取当前日期时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime:" + localDateTime.toString());
        //后面还可以加时区
        System.out.println("format local date time:" + localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        // 设置日期
        LocalDate localDate = LocalDate.of(2019, 9, 10);


//        // 获取当前时间
//        LocalTime now = LocalTime.now();
//        // 设置时间
//        LocalTime localTime = LocalTime.of(13, 51, 10);

        // 设置日期
//        LocalDateTime localDateTime1 = LocalDateTime.of(2019, Month.SEPTEMBER, 10, 14, 46, 56);
//        LocalDateTime localDateTime2 = LocalDateTime.of(localDate, localTime);
//        LocalDateTime localDateTime3 = localDate.atTime(localTime);
//        LocalDateTime localDateTime4 = localTime.atDate(localDate);
        // 获取LocalDate
        LocalDate localDate2 = localDateTime.toLocalDate();
        // 获取LocalTime
        LocalTime localTime2 = localDateTime.toLocalTime();
        System.out.println(localDate2.toString());
        System.out.println(localTime2.toString());


        short a = 4;
        Integer b=  4;
        System.out.println(b == a);

        LocalDate nowLocalDate = LocalDate.now();
        long timestamp = nowLocalDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(new Date());
        Date nowTime = sdf.parse(time);

        System.out.println("nowTime:"+ nowTime + " ===== " + time + (timestamp == nowTime.getTime()));


        Date nowDate = Date.from(nowLocalDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant());
        System.out.println("nowDate:" + nowDate);


        System.out.println("====" + getNowFormatDay());
        System.out.println("====" + now());
    }


    public static Long getNowFormatDay(){
        LocalDate nowLocalDate = LocalDate.now();
        return Date.from(nowLocalDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant()).getTime();
    }

    public static Long now() {
        LocalDate nowLocalDate = LocalDate.now();
        return Date.from(nowLocalDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant()).getTime();
    }


}
