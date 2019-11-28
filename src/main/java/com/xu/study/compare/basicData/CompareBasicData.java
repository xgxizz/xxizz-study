package com.xu.study.compare.basicData;

import org.junit.jupiter.api.Test;

/**
 * @Description
 * @Author xgx
 * @Date 2019/11/28 17:58
 */
public class CompareBasicData {


//    基本数据类型，也称原始数据类型。byte,short,char,int,long,float,double,boolean
//    他们之间的比较，应用双等号（==）,比较的是他们的值。
    @Test
    public void intData(){
        int a = 12;
        int b = 12;
        System.out.println(a == b);

        Integer aa = 12;
        Integer bb = 12;
        System.out.println(aa == bb);
        System.out.println(aa.equals(bb));


        Integer aaa = new Integer(12);
        Integer bbb = new Integer(12);
        System.out.println(aaa == bbb);
        System.out.println(aaa.equals(bbb));
    }
}
