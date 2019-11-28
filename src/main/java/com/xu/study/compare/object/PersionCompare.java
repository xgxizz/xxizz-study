package com.xu.study.compare.object;

import org.junit.jupiter.api.Test;

/**
 * @Description
 * @Author xgx
 * @Date 2019/11/28 18:06
 */
public class PersionCompare {

    @Test
    public void compare(){
        Persion persionA = new Persion("xgx",23);
        Persion persionD = new Persion("xgx",23);
        System.out.println(persionA == persionD);
        System.out.println(persionA.equals(persionD));
    }
}
