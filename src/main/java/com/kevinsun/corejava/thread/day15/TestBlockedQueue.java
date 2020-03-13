package com.kevinsun.corejava.thread.day15;

import java.util.Random;

public class TestBlockedQueue {

    public static void main(String[] args) {
        BlockedQueue bq = new BlockedQueue(10);
        while (true) {


            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    String str = new Random().nextInt()*1000+"";
                    bq.put(str);
                    System.out.println("生产消息："+str);
                }
            });


            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    Object obj=bq.get();
                    System.out.println("消费消息："+obj);
                }
            });

           // t1.start();
            t2.start();
        }
    }
}
