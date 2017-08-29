package com.cloud.moon.autoBoxing;

/**
 * Created by zhangyubo02 on 2017/8/24.
 */
public class TestAutoBoxing {
    public static void main(String[] args) {
        Integer integer = null;
        boolean flag = integer == 0;
        System.out.println(flag);
    }
}
