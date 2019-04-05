package com.example.javalib;

import java.applet.*;
import java.util.TreeMap;

public class MyTest extends Applet {
    public static void main(String[] args) {
        new MyTest().test();
        int i = 0;
        i= i ++;
        System.out.println(i);
        TreeMap t;
    }

    public void add(Byte b) {
        b = b++;
    }

    public void test() {
        Byte a = 127;
        Byte b = 127;
        add(++a);
        System.out.print(a + " ");
        add(b);
        System.out.print(b + "");
    }
}

class Foo {
    public Foo(String word) {
        System.out.println(word);
    }

    public Foo(int i){}
    public void PP(){}
}

class Parent extends Foo{

    Foo foo = new Foo("Parent's parameter");

    static {
        System.out.println("Parent's static code block ");
    }

    static Foo FOO1 = new Foo("Parent's static parameter");

    {
        System.out.println("Parent's code block");
    }

    public Parent(int p) {
        super(p);
        System.out.println("Parent.Parent()");
    }
}

class Child extends Parent {
    static Foo FOO = new Foo("Child's static parameter");

    Foo foo = new Foo("Child's parameter");

    static {
        System.out.println("Child's static code block");
    }

    {
        System.out.println("Child's code block");
    }

    public Child(int c) {
        super(c);
        super.foo.hashCode();
        super.PP();
        System.out.println("Child.Child()");
    }
}