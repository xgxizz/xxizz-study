package com.xu.study.string;


import org.junit.Test;

/**
 * @Description
 * @Author xgx
 * @Date 2019/11/22 16:42
 */
public class StringTest {

    @Test
    public void testSubString(){
        String str = "0123456789";
        System.out.println(str.substring(0,4));
        System.out.println(str.substring(4));
    }

    @Test
    public void testEquel(){
        String str = new String("hello");
        String str1 = new String("hello");
        System.out.println(str == str1);
    }
}
