package com.xu.spi;

/**
 * Description: <br/>
 *
 * @author: xgx <br/>
 * date: 2020/9/18 10:24 <br/>
 */
public class SPIServiceImpl02 implements SPIService {
    @Override
    public void sayHello() {
        System.out.println("hello! this is impl 02 !");
    }
}
