package org.kevinsun.corejava.thread.day01;

import org.omg.Messaging.SyncScopeHelper;

public class TestAdd10k {
/**
 * 不正确的使用Volatile 对性能影响还是很大的。
 *
 * */
    public static void main(String[] args) throws InterruptedException {
        Add10k add=new Add10k();

        long starttime=System.currentTimeMillis();
        long count= add.calc();
        long endtime=System.currentTimeMillis();
        System.out.println("运行时间："+(endtime-starttime));
        System.out.println("===="+count);


        long starttime2=System.currentTimeMillis();
        long count2= add.calcForVolatile();
        long endtime2=System.currentTimeMillis();
        System.out.println("运行时间："+(endtime2-starttime2));
        System.out.println("===="+count2);
    }
}
