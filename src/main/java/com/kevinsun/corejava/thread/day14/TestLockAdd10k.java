package org.kevinsun.corejava.thread.day14;




public class TestLockAdd10k {
/**
 * 可能的运行结果：
 * ===200000000
 * celc2运行时间==7461
 * ===400000000
 * celc运行时间==10206
 *
 * 结论： celc2 使用synchronized同步代码块，celc使用synchronized同步方法， 同步范围越小，性能越好。
 *
 *
 * */
    public static void main(String[] args) throws InterruptedException {
        LockAdd10k add=new LockAdd10k();
        /*long s2= System.currentTimeMillis();
        long count2= add.celc2();
        System.out.println("==="+count2);
        long e2= System.currentTimeMillis();
        System.out.println("celc2运行时间=="+(e2-s2));

        long s1= System.currentTimeMillis();
        long count=add.celc();
        System.out.println("==="+count);
        long e1= System.currentTimeMillis();
        System.out.println("celc运行时间=="+(e1-s1));*/


        long s3= System.currentTimeMillis();
        long count3=add.celc3();
        System.out.println("==="+count3);
        long e3= System.currentTimeMillis();
        System.out.println("celc3运行时间=="+(e3-s3));

       /* long s4= System.currentTimeMillis();
        long count4=add.celc4();
        System.out.println("==="+count4);
        long e4= System.currentTimeMillis();
        System.out.println("celc4运行时间=="+(e4-s4));*/


    }
}
