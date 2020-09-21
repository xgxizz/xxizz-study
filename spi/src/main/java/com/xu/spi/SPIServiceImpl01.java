package com.xu.spi;

/**
 * Description: <br/>
 *
 * @author: xgx <br/>
 * date: 2020/9/18 10:23 <br/>
 */
public class SPIServiceImpl01 implements SPIService{
    @Override
    public void sayHello() {
        System.out.println("hello, this impl01 !");
    }
}
