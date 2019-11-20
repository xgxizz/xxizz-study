package com.xu.study.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description
 * @Author xgx
 * @Date 2019/9/18 18:30
 */
public class Test {

    public static void main(String[] args) {
        String str = "5 筷子兄弟 101 薛之谦 9 刘德华 18 热狗 19 韩红";
        String splits[] = str.split(" ");
        //int len = splits.length/2;
        List<Singer> singers = new ArrayList<>();
        if (splits.length>0){
            for (int i = 0; i < splits.length; i=i+2) {
                Singer singer = new Singer();
                singer.setNum(Integer.parseInt(splits[i]));
                singer.setName(splits[i+1]);
                singers.add(singer);
            }
        }
        Collections.sort(singers, (o1, o2) -> {
            int diff = o1.getNum() - o2.getNum();
            if (diff > 0 ){
                return 1;
            }else if(diff < 0){
                return -1;
            }else{
                return 0;
            }
        });
        System.out.println(singers.toString());

    }
}
