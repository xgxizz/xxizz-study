package com.xu.study.compare.string;

import org.junit.jupiter.api.Test;

/**
 * @Description
 * @Author xgx
 * @Date 2019/11/28 18:09
 */
public class StringCompare {

    //参考链接：https://www.cnblogs.com/limeiky/p/4831992.html
    @Test
    public void compare(){

        String str1 = "abc";
        String str2 = "abc";

        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));

        String str3 = new String("str1");
        System.out.println(str1 == str3);
        System.out.println(str1.equals(str3));

        StringBuffer buffer1 = new StringBuffer(str1);
        StringBuffer buffer2 = new StringBuffer(str2);
        System.out.println(buffer1 == buffer1);
        System.out.println(buffer1.equals(buffer2));

    }
}
