package com.cloud.moon.rtti;

import java.util.Random;

/**
 * 本例来自《thinking in java》 p319 介绍延迟初始化
 * 什么时候会对一个类进行静态初始化：
 * 1.调用静态方法（构造方法也算静态方法）
 * 2.引用非final的静态域
 * 3.如果一个final的静态域是一个对象，那么引用这个静态域也会触发静态初始化
 * @author zhangyubo02
 * create time : 2017/11/9.
 */
public class LazyInitDemo {
    public static Random rand = new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {
        //不会触发初始化操作
        Class initable = Initable.class;
        System.out.println("引用Initable.class");
        //不会触发初始化操作
        System.out.println("Initable.staticFinal:" + Initable.staticFinal);
        //触发初始化操作
        System.out.println("Initable.staticFinal2:" + Initable.staticFinal2);
        //触发初始化操作
        System.out.println("Initable2.staticNonFinal:" + Initable2.staticNonFinal);
        //触发初始化操作
        Class.forName("com.cloud.moon.rtti.Initable3");
        System.out.println("class forname Initable3");
        System.out.println("Initable3.staticNonFinal:" + Initable3.staticNonFinal);
    }
}
class Initable {
    static final int staticFinal = 47;
    static final int staticFinal2 = LazyInitDemo.rand.nextInt(1000);
    static {
        System.out.println("Initable init ...");
    }
}
class Initable2 {
    static int staticNonFinal = 147;
    static {
        System.out.println("Initable2 init ...");
    }
}
class Initable3 {
    static int staticNonFinal = 74;
    static {
        System.out.println("Initable3 init ...");
    }
}