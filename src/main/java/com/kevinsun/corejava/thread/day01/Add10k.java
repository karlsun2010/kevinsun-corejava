package org.kevinsun.corejava.thread.day01;


public class Add10k {
    private  long count1 = 0;
    private void add10k() {
        for (int i = 0; i < 100000000; i++) {
            count1+=1;
        }
    }

    private volatile long count2 = 0;
    private void add10kForVolatile() {
        for (int i = 0; i < 100000000; i++) {
            count2+=1;
        }
    }


    public  long calc() throws InterruptedException {


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                add10k();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                add10k();
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        return count1;
    }



    public  long calcForVolatile() throws InterruptedException {


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                add10kForVolatile();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                add10kForVolatile();
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        return count2;
    }

}