package com.example.myapplication;

public class HongBao {
    /**
     * 假设这个类有很多方法，我们省略一些其他的方法...
     */
    /**
     * 该jni方法是测试两个数字相加并返回该结果...
     * @param x
     * @param y
     * @return
     */
    public static native int add(int x, int y);

    /**
     * 测试两个整形数字相减
     * @param x
     * @param y
     * @return
     */
    public static int sub(int x, int y) {
        return x - y;
    }
}
