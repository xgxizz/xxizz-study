package com.xu.study.compare;

/**
 * @Description
 * @Author xgx
 * @Date 2019/9/18 18:41
 */
public class Singer {
    private int num;
    private String name;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Singer{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }
}
