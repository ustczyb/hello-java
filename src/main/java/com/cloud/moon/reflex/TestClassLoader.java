package com.cloud.moon.reflex;

/**
 * Created by zhangyubo02 on 2017/8/16.
 */
public class TestClassLoader {
    public static void main(String[] args) {
        System.out.println(TestClassLoader.class.getClassLoader().getClass().getName());
        System.out.println(String.class.getClassLoader());
    }
}
