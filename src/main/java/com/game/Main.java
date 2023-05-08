package com.game;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        Spider spider = new Spider("https://pvp.qq.com/web201605/herolist.shtml");

        //匹配http://www.goupuzi.com/attachment/thumb/Mon_1601/***.jpg的中的图片
        String regex = "//game.gtimg.cn/images/yxzj/img201606/heroimg/.+?\\.jpg";

        List<String> list = spider.getByRegex(regex);


        for (String url : list) {


            System.out.println(url);

            new Download("https:"+url,"img/").start();

        }


    }
}
