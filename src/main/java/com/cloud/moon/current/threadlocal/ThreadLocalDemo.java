package com.cloud.moon.current.threadlocal;

/**
 * @author zhangyubo02
 * create time : 2017/12/19.
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
        stringThreadLocal.set("haha");
        stringThreadLocal.get();
    }
}
