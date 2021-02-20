package com.cwnu.base;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class NowDayTest {
    public static void main(String[] args) {
        //关注 日期 + 时间
        LocalDateTime localDateTime = LocalDateTime.now();
        Date date = Date.from(localDateTime.atZone(ZoneOffset.ofHours(8)).toInstant());
        //转换成当天的yyyy-MM-dd格式
        System.out.println(date);

        //关注日期
        LocalDate localDate;
        //关注时间
        LocalTime localTime;

        java.sql.Time time = new Time(System.currentTimeMillis());
        System.out.println(time.toString());

        System.out.println(UUID.randomUUID().toString().length());


        List<Long> classIds = new ArrayList<>();
        System.out.println(classIds.contains("aaa"));
    }
}
