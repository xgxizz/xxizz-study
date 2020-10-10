package com.xu.classloader.testdir;

import com.xu.classloader.anno.ImporterSource;

/**
 * Description: <br/>
 *
 * @author: xgx <br/>
 * date: 2020/9/21 16:36 <br/>
 */
@ImporterSource(src = "TestServiceImpl01")
public class TestServiceImpl01 implements TestService {
    @Override
    public void sayHello() {
        System.out.println("hello, TestServiceImpl01.");
    }
}
