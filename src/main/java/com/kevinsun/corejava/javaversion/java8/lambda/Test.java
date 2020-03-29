package com.kevinsun.corejava.javaversion.java8.lambda;

public class Test {
    private int operate(int a, int b, Operation operation) {
        return operation.operation(a, b);
    }

    public static void main(String[] args) {
        Test test = new Test();

        //java8 之前
        test.operate(1, 2, new Operation() {
            @Override
            public int operation(int a, int b) {
                return a + b;
            }
        });

        //java8 lambda
        test.operate(1,2,(a,b) -> a+b);
    }
}






