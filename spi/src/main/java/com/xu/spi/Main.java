package com.xu.spi;

import java.util.ServiceLoader;

/**
 * Description: <br/>
 *
 * @author: xgx <br/>
 * date: 2020/9/18 10:25 <br/>
 */
public class Main {
    public static void main(String[] args) {
        ServiceLoader<SPIService> spiServices = ServiceLoader.load(SPIService.class);
        for (SPIService spiService : spiServices) {
            spiService.sayHello();
        }
    }
}
