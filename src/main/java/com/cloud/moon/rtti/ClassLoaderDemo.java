package com.cloud.moon.rtti;

/**
 * Created by zhangyubo02 on 2017/8/16.
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {
        System.out.println(ClassLoaderDemo.class.getClassLoader().getClass().getName());
        System.out.println(String.class.getClassLoader());
    }
}
