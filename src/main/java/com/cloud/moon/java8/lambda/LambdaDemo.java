package com.cloud.moon.java8.lambda;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by zhangyubo02 on 2017/9/17.
 */
public class LambdaDemo {
    @Test
    public void test1() {
        List<String> names = Arrays.asList("peter","tom","anna","mike");
//        Collections.sort(names,(String s1, String s2) -> {return s1.compareTo(s2);});
        Collections.sort(names,(s1, s2) -> (s1.compareTo(s2)));
        System.out.println(names);
    }

    /**
     * predice 内置的函数接口
     * 接收一个参数，返回一个boolean
     */
    @Test
    public void testPredicate() {
        Predicate<String> predicate = (s -> (s == null && s.isEmpty()));
        Predicate<String> predicate2 = Objects::nonNull;
        System.out.println(predicate2.test(""));
    }

    /**
     * Function<S,T>
     * 接受一个S类型的参数，返回一个T类型的参数
     */
    @Test
    public void testFunctions() {
        Function<String, Integer> function = ((s) -> (s.length()));
        System.out.println(function.apply(""));
    }

    /**
     * Supplier<T>
     * 不接收参数，返回一个T类型的对象
     */
    @Test
    public void testSupplier() {
        Supplier<String> stringSupplier = (() -> ("abc"));
        System.out.println(stringSupplier.get());
    }

    /**
     * Consumer<T>
     * 接受一个T类型的参数，不返回任何结果
     */
    @Test
    public void testConsumer() {
        Consumer<String> consumer = ((s -> {
            System.out.println(s);
        }));
        consumer.accept("123");
    }

}
