package com.xu.classloader.testdir.in;

import com.xu.classloader.anno.ImporterSource;
import com.xu.classloader.testdir.TestService;

/**
 * Description: <br/>
 *
 * @author: xgx <br/>
 * date: 2020/9/21 16:36 <br/>
 */
@ImporterSource(src = "TestServiceImpl04")
public class TestServiceImpl04 implements TestService {
    @Override
    public void sayHello() {
        System.out.println("hello, TestServiceImpl04.");
    }
}
