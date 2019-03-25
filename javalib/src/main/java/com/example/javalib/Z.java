package com.example.javalib;

class Y {
    Byte x;

    public Y() {
//        System.out.println("y");
    }
}
class X extends Y {

    Y y = new Y();

    public X() {
        System.out.println("X");
    }
   Y start2() {
        return null;
    }

}
class Z extends X {
    Y y = new Y();

    public Z() {
//        System.out.println("z");
    }

   final X start() {

        final  Y y = new Y();
        System.out.println("" + y.x);
        Y y2 = fix(y);
        System.out.println("" + y.x + " " + y2.x);
        return null;
    }

    Y fix(Y yy) {
        yy.x = 42;
        return yy;
    }

    public static void main(String[] args) {
        Z z=new Z();
        z.start2();
    }
}

