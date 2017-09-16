package com.cloud.moon.io.serialize.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by zhangyubo02 on 2017/9/2.
 */
@Data
public class Person implements Serializable {


    private static final long serialVersionUID = 7391058309744596247L;
    private String name;
    private String age;
    private String gender;

    public void test(){

    }
}
