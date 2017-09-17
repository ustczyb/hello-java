package com.cloud.moon.exception;

import org.junit.Test;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by zhangyubo02 on 2017/8/29.
 */
public class ExceptionDemo {

    @Test
    public void test1(){
        int a = 10;
        try{
            a = 6;
            a = 1/0;
        } finally {
            System.out.println(a);
        }
    }

    @Test
    public void test2(){            //异常被抛出后，会跳出这段代码的执行逻辑直到被catch或者遇到finally
        int a = 10;
        a = 1/0;
       System.out.println(a);
    }

    @Test
    public void test3(){            //异常丢失，finally语句块中抛出新的异常
        try{
            int a = 1 / 0;
        } finally {
            int[] arr = new int[3];
            arr[3] = 0;
            System.out.println("finally run");
        }
    }
}
