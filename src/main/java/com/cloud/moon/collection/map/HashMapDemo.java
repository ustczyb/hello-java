package com.cloud.moon.collection.map;

import java.util.HashMap;

/**
 * Created by zhangyubo02 on 2017/10/13.
 */
public class HashMapDemo {

    public static void main(String[] args) {
        HashMap<Integer, String> integerStringHashMap = new HashMap<>();
        integerStringHashMap.put(2,"value2");
        System.out.println(integerStringHashMap.get(2));
        System.out.println(integerStringHashMap.get(2L));
        integerStringHashMap.put(999,"value999");
        System.out.println(integerStringHashMap.get(999));
        System.out.println(integerStringHashMap.get(Integer.valueOf(999)));
    }
}
