package org.kevinsun.corejava.thread.day14;


import javafx.scene.chart.ScatterChart;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockAdd10k {
    private  long  count=0;
    Lock lock1=new ReentrantLock();

    Lock fairlock=new ReentrantLock(true);  //公平锁


    private synchronized void  add10k(){
        int i=0;
        while(i<100000000){
            i++;
            synchronized (this){
                count+=1;
            }
        }
    }


    private  void  add10k2(){
        int i=0;
        while(i<100000000){
            i++;
            synchronized (this){
                count+=1;
            }
        }
    }

    private  void  add10k3(){


            int i=0;
            while(i<100){
                i++;
                fairlock.lock();
                System.out.println(Thread.currentThread().getName()+"得到锁");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                count+=1;
                } finally {
                    System.out.println(Thread.currentThread().getName()+"释放锁");
                    fairlock.unlock();
                }
            }

    }


    private  void  add10k4(){
        lock1.lock();
        try {
            int i=0;
            while(i<100000000){
                i++;
                count+=1;
            }
        } finally {
            lock1.unlock();
        }
    }


    public   long celc() throws InterruptedException {
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                add10k();
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                add10k();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();



        return  count;

    }


    public   long celc2() throws InterruptedException {
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                add10k2();
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                add10k2();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();



        return  count;

    }

    public   long celc3() throws InterruptedException {
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                add10k3();
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                add10k3();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();



        return  count;

    }




    public   long celc4() throws InterruptedException {
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                add10k4();
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                add10k4();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();



        return  count;

    }

}
