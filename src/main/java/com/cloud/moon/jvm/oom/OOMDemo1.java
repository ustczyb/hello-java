package com.cloud.moon.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangyubo02 on 2017/8/29.
 */
public class OOMDemo1 {
    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
