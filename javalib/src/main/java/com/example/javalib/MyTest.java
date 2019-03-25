package com.example.javalib;


class MyTest extends Thread{

    public static void main(String args[]) {
        MyTest b = new MyTest();
        b.run();
    }

    public void start() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Value of i = " + i);
        }
    }
}
