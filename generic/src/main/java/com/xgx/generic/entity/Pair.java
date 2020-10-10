package com.xgx.generic.entity;

/**
 * Description: <br/>
 *
 * @author: xgx <br/>
 * date: 2020/9/25 11:55 <br/>
 */
public class Pair<T> {
    private T name;
    private T age;

    public Pair(T name, T age) {
        this.name = name;
        this.age = age;
    }

    public Pair() {
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public T getAge() {
        return age;
    }

    public void setAge(T age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }
}
