package com.cloud.moon.java8.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangyubo02 on 2017/9/20.
 */
public class MapDemo {

    private Map<Integer, String> map;

    @Before
    public void init() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"c");
    }

    @Test
    public void testForEach() {
        map.forEach((i,s) -> {
            System.out.println(i + ":" + s);
        });
    }

    @Test
    public void testGetOrDefault() {
        System.out.println(map.getOrDefault(3,"v"));
        System.out.println(map.getOrDefault(4,"v"));
    }

    @Test
    public void testMerge() {
        map.putIfAbsent(1,"1");
    }
}
