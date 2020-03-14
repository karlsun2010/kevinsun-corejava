package org.kevinsun.corejava.thread.day01;

public class Singleton {

    String name="zhangsan";


    static Singleton instance ;
    static Singleton getInstance(){
        if(instance==null){
            synchronized (Singleton.class){
                if (instance==null){
                    instance=new Singleton();

                }
            }
        }
        return instance;

    }

}
