package com.kevinsun.corejava.javaversion.java8.localdate;

import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Test {
    //以后可以和旧的日期类说拜拜了，用java8 提供的日期类就对了，易用性，线程安全等等。

    public static void main(String[] args) {
       /* LocalDate now = LocalDate.now();
        System.out.println(now);
        System.out.println(now.getYear());
        System.out.println(now.getMonth());
        System.out.println(now.getDayOfMonth());

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        LocalDateTime localDateTime = now.atTime(localTime);
        System.out.println(localDateTime);*/

        //dateDemo();
        //calendarDemo();
        //java8InstantDemo();
        java8Clock();
    }


    public static void dateDemo() {
        Date date1 = new Date(14686531L);
        System.out.println(date1);
        Date date2 = new Date();
        System.out.println(date2);
    }

    // 创建Calendar对象
    public static void calendarDemo() {


        Calendar c = Calendar.getInstance();
        System.out.println(c);

        // 获取Hour属性的值
        int hour = c.get(Calendar.HOUR);
        System.out.println(hour);

        c.set(Calendar.HOUR, 12);

        // 获取Date对象的方法
        Date d = c.getTime();
        System.out.println(d);
    }


    public static void java8InstantDemo() {
        Instant ins = Instant.now();
        System.out.println(ins);

        Instant now = Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8));
        System.out.println("now:" + now);
        System.out.println("秒数:" + now.getEpochSecond());
        System.out.println("毫秒数:" + now.toEpochMilli());


        LocalDateTime localDateTime = LocalDateTime.now();
        //LocalDateTime转Instant
        Instant localDateTime2Instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        System.out.println("LocalDateTime 毫秒数:" + localDateTime2Instant.toEpochMilli());

    }


    public static void java8Clock() {

        Clock clock = Clock.systemUTC();
        System.out.println("Clock : " + clock.millis());

// Returns time based on system clock zone
        Clock defaultClock = Clock.systemDefaultZone();
        System.out.println("Clock : " + clock.getZone());
    }
}
