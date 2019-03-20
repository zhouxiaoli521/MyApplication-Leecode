package com.example.myapplication;

public class JNITest {

//    static {
//        System.loadLibrary("MyApplication");
//    }

    public native static String get();
    public native String  dynamicGenerateKey(String name);
}
