package com.example.javalib;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class X {
    Y y = new Y();

    public X() {
//        System.out.println("X");
    }
}

class Y {
Byte x;
    public Y() {
//        System.out.println("y");
    }
}

 class Z extends X {
    Y y = new Y();

    public Z() {
//        System.out.println("z");

    }

    void start(){

        Y y=new Y();
        System.out.println(""+y.x);
        Y y2=fix(y);
        System.out.println(""+y.x+" "+y2.x);
    }
    Y fix(Y yy){
        yy.x=42;
        return yy;
    }

    public static void main(String[] args) {
        Collection<?>[] collections =
                {new HashSet<String>(), new ArrayList<String>(), new HashMap<String, String>().values()};
        Super subToSuper = new Sub();
        for(Collection<?> collection: collections) {
            System.out.println(subToSuper.getType(collection));
    }
    }
    abstract static class Super {
        public static String getType(Collection<?> collection) {
            return "Super:collection";
        }
        public static String getType(List<?> list) {
            return "Super:list";
        }
        public String getType(ArrayList<?> list) {
            return "Super:arrayList";
        }
        public static String getType(Set<?> set) {
            return "Super:set";
        }
        public String getType(HashSet<?> set) {
            return "Super:hashSet";
        }
    }
    static class Sub extends Super {
        public static String getType(Collection<?> collection) {
            return "Sub"; }
    }
}

