package com.example.javalib;

public class MyTest {
    public static void main(String[] args) {
        int a[]=new int[5];
        System.out.println(a.length);
}


      static class A {
        int value;
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
