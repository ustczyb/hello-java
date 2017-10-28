package com.cloud.moon.datetime;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author zhangyubo02
 * @date 2017/9/16
 * java的日期时间处理api
 */
public class DateDemo {

    /**
     * Date类的使用
     */
    @Test
    public void testDate() {
        //获取当前时间
        Date date = new Date();
        System.out.println(date);
        //接受一个时间戳(1970年到现在的毫秒数)
        date = new Date(123L);
        System.out.println(date);
        //获取时间戳(1970年到现在的毫秒数)
        System.out.println(date.getTime());

        Date date1 = new Date();
        Date date2 = new Date(0L);
        System.out.println(date1.before(date2));
        System.out.println(date1.after(new Date()));
    }

    /**
     *
     */
    @Test
    public void testDateFormat() throws ParseException {
        String s = "Oct 17 2017:12:25:00";
        DateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy:HH:mm:ss");
        System.out.println(dateFormat.parse(s));
        //字符串转日期
        dateFormat = new SimpleDateFormat("yyyy-M-dd hh:mm:ss");
        String dateString = "2014-11-23 12:23:34";
        Date date = dateFormat.parse(dateString);
        System.out.println(date);
        //日期转字符串
        dateFormat = new SimpleDateFormat("yyMMMdd hh:mm:ss");
        dateString = dateFormat.format(date);
        System.out.println(dateString);
        //日期格式本地化
        dateFormat = new SimpleDateFormat("yyMMMDD hh:mm:ss", Locale.US);
        dateString = dateFormat.format(date);
        System.out.println(dateString);
    }
}
