package com.kevinsun.corejava.thread.day15;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockedQueue<T> {

    private final int maxSize;
    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();
    List<T> list;


    public BlockedQueue(int size) {
        this.maxSize = size;
        this.list = new LinkedList<T>();
    }

    public void put(T x) {
        lock.lock();
        try {
            if (this.list.size() >= maxSize) {
                try {
                    System.out.println("队列已满 等待消费");
                    this.notFull.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(x);
            notEmpty.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }


    public T get() {
        lock.lock();
        try {
            if (this.list.size() == 0) {
                try {
                    System.out.println("队列已空 等待生产");
                    this.notEmpty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            notFull.signal();
            T t = list.remove(0);
            return t;
        }  finally {
            lock.unlock();
        }



}


}
