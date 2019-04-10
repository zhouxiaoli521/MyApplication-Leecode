package com.example.javalib;

import java.applet.Applet;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MyTest extends Applet {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        Random rand = new Random();
        int n=10;
        boolean[] bool = new boolean[n];
        int num = 0;
        for (int i = 0; i < n; i++) {
            do {
                // 如果产生的数相同继续循环
                num = rand.nextInt(n);
            } while (bool[num]);
            bool[num] = true;
            list.add(num);
        }
        System.out.print(list.toString());
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
    final public void PP(){System.out.println("====f===");}
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
    public void pp(){
        System.out.println("====p===");
    };
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
        System.out.println("Child.Child()");
    }

    public void pp(){
        System.out.println("====c===");
    };
}