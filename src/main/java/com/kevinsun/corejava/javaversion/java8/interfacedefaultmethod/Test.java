package com.kevinsun.corejava.javaversion.java8.interfacedefaultmethod;

public class Test {
    public static void main(String[] args) {


        Boy boy = new Boy() {
            @Override
            public void run() {
                System.out.println("boy run");
            }
        };
        boy.run();
        boy.cry("ma ma");
    }


}
