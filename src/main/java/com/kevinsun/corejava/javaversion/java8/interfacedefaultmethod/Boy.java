package com.kevinsun.corejava.javaversion.java8.interfacedefaultmethod;

public interface Boy {

    void run();

    default String cry(String word){
        System.out.println("boy cry"+word);
        return word;
    }


}


