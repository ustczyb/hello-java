package com.cloud.moon.rtti.reflax;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhangyubo02
 * create time : 2017/11/2.
 */
public class TestMethod {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        TestMethod testMethod = new TestMethod();
//        testMethod.throwNpe();
        Class klass = testMethod.getClass();
        Method method = klass.getMethod("throwNpe");
        method.invoke(testMethod, null);
    }

    public void throwNpe() {
        Integer integer = null;
        System.out.println(integer.toString());
    }
}
