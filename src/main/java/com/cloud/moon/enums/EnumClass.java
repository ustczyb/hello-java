package com.cloud.moon.enums;

/**
 * @author zhangyubo02
 * create time : 2017/11/8.
 */
public class EnumClass {
    public static void main(String[] args) {
        for(Subject subject : Subject.values()) {
            //ordinal()方法可以获取enum实例声明的次序 自带的equals方法和compareTo方法就是比较的这个值
            System.out.println(subject.ordinal());
            System.out.println(subject.compareTo(Subject.ENGLISH));
            //getDeclaringClass获取这个枚举的类
            System.out.println(subject.getDeclaringClass());
            //toString方法即为这个枚举的名字
            System.out.println(subject.toString());
        }
    }
}