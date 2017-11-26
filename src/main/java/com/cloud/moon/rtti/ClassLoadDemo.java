package com.cloud.moon.rtti;

/**
 *  类加载Demo
 *  @author zhangyubo02
 *  @date 2017/8/16
 */
public class ClassLoadDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("main() run");
        new A();
        System.out.println("after A created");
        Class.forName("com.cloud.moon.rtti.B");
        System.out.println("after B forName");
    }
}
class A{
    static {
        System.out.println("Class A init...");
    }
}
class B{
    static {
        System.out.println("Class B init...");
    }
}
