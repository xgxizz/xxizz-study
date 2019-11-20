package com.xu.study.javabase.proxy.cglib;

/**
 * @Description 简单Java对象
 * @Author xgx
 * @Date 2019/9/18 14:10
 */
public class SimpleClass {

    public void test(){
        System.out.println("hello world");
    }
    public String test(String input){
        return "hello world";
    }
}
