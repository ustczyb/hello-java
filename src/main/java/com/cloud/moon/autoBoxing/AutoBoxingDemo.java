package com.cloud.moon.autoBoxing;

/**
 * Created by zhangyubo02 on 2017/8/24.
 */
public class AutoBoxingDemo {
    public static void main(String[] args) {
//        Integer integer = null;
//        boolean flag = integer == 0;
//        System.out.println(flag);

//        System.out.println(Math.toIntExact(199));

        Integer j = 127;
        Integer i = rpcInt();
        System.out.println(j == i);
    }

    private static Integer rpcInt() {
        Integer i = 127;
        return i;
    }
}
