package com.cloud.moon.enums;

import org.junit.Test;

import java.util.EnumMap;
import java.util.EnumSet;

/**
 * @author zhangyubo02
 * create time : 2017/11/8.
 */
public class EnumSetDemo {

    @Test
    public void testEnumSet() {
        EnumSet<Subject> enumSet = EnumSet.allOf(Subject.class);
        for(Subject subject : enumSet) {
            System.out.println(subject);
        }
    }

    @Test
    public void testEnumMap() {
        EnumMap<Subject, String> enumMap = new EnumMap<Subject, String>(Subject.class);
    }
}
