package com.xgx.generic.test;

import com.xgx.generic.entity.IGeneric;

import java.util.Random;

/**
 * Description: <br/>
 *
 * @author: xgx <br/>
 * date: 2020/9/25 14:39 <br/>
 */
public class FruitIGeneric implements IGeneric<String> {
    private String[] fruits = new String[]{"Apple", "Banana", "Pear"};
    @Override
    public String next() {
        Random rand = new Random();
        return fruits[rand.nextInt(3)];
    }

    public static void main(String[] args) {
        IGeneric fruit = new FruitIGeneric();
        System.out.println(fruit.next());
    }
}
