package com.cloud.moon.java8.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by zhangyubo02 on 2017/9/18.
 */
public class StreamDemo {

    private List<String> stringList;

    @Before
    public void init() {
        stringList = new ArrayList<>();
        stringList.add("aaa");
        stringList.add("bbb");
        stringList.add("ddd");
        stringList.add("ccc");
    }

    /**
     * forEach 接收一个consumer,对当前stream中的所有对象执行方法,终结
     */
    @Test
    public void testForEach() {
        stringList.forEach(System.out::println);
    }

    /**
     * filter 接收一个Predicate,对当前stream中的所有对象进行过滤,中间
     */
    @Test
    public void testFilter() {
        stringList.stream()
                .filter((s -> (s.startsWith("a"))))
                .forEach(s -> {
                    System.out.println(s);
                });
    }

    @Test
    public void testSorted() {

    }

    /**
     * map 中间操作 接收一个Function 将stream中的每一个元素映射到另一个元素
     */
    @Test
    public void testMap() {
        stringList.stream()
                .map(s -> (s.length()))
                .forEach(System.out::println);
    }

    /**
     * match 终结操作 接收一个Predicate 将stream映射到boolean类型
     */
    @Test
    public void testMatch() {
        boolean allMatch = stringList.stream()
                .allMatch(s -> s.startsWith("a"));
        System.out.println(allMatch);
        boolean anyMatch = stringList.stream().anyMatch(s -> s.startsWith("a"));
        System.out.println(anyMatch);
    }

    /**
     * count 终结操作 无参数 返回stream中的元素个数 long类型
     */
    @Test
    public void testCount() {
        long count = stringList.stream().count();
        System.out.println(count);
    }

    /**
     * reduce 终结操作 接收一个二元运算操作
     */
    @Test
    public void testReduce() {
        Optional<String> str = stringList.stream()
                .sorted()
                .reduce((s1, s2) -> (s1 + "#" + s2));
        str.ifPresent(s -> System.out.println(s));
    }

    @Test
    public void testCollect() {
        List<String> list = stringList.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(list);
    }

    /**
     * 使用flatmap将多个stream合并成一个
     */
    @Test
    public void testFlatMap() {
        List<List<Integer>> listList = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(11, 22, 33), Arrays.asList(12, 23, 31), Arrays.asList(13, 21, 32));
        List<Integer> integers = listList.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(integers);
    }

}
