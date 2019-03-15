package com.example.javalib;

import java.util.ArrayList;
import java.util.Iterator;

public class MyTest {
    public static void main(String[] args) {
        ArrayList list=null;
        Iterator it = list.iterator();
        int index = 0;
        while (it.hasNext())
        {
            Object obj = it.next();
            it.remove();
            list.remove(9);
            index ++;
        }
}


      static class A {
        protected int value;
        public A (int v) {
//            setValue(v);
        }
        public void setValue(int value) {
            this.value= value;
        }
        public int getValue() {
            try {
                value ++;
                return value;
            } finally {
                this.setValue(value);
                System.out.println(value);
            }
        }
          public void printValue()
          {
              System.out.println("A");
          }
    }
    static class B extends A {
        public B () {
            super(5);
//            setValue(getValue()- 3);
        }
        public void setValue(int value) {
            super.setValue(2 * value);
        }
        public void printValue()
        {
            System.out.println("B");
        }
    }
}
