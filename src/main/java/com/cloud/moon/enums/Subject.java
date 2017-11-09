package com.cloud.moon.enums;

/**
 * @author zhangyubo02
 * create time : 2017/11/8.
 */
public enum Subject {
    MATH {
        @Override
        String getInfo() {
            return "math";
        }
    },
    ENGLISH {
        @Override
        String getInfo() {
            return "english";
        }
    },
    HISTORY {
        @Override
        String getInfo() {
            return "history";
        }
    };
    abstract String getInfo();
}
