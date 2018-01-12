package com.cloud.moon.java8.lambda;

import java.util.Optional;

/**
 * @author zhangyubo02
 * create time : 2018/1/12.
 */
public class OptionalDemo {

    public static void main(String[] args) {
        String test = "te";
        // 将一个对象包装为optional类型
        Optional<String> optional = Optional.ofNullable(test);
        // 对optional类型对象操作
        System.out.println(optional.filter(s -> {
                    System.out.println("length < 3");
            return s.length() > 3;}
            ).map(s -> s.substring(3)).orElse("sub"));
        // 解包
        System.out.println(optional.orElse("else"));
    }
}
