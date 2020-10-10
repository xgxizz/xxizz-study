package com.xgx.generic.test;

import com.xgx.generic.entity.Pair;

/**
 * Description: <br/>
 *
 * @author: xgx <br/>
 * date: 2020/9/25 11:57 <br/>
 */
public class TestPair {
    public static void main(String[] args) {
        Pair<String> pair = new Pair<>("xgx", "100");
        System.out.println(pair);
    }
}
