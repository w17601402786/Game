package com.game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Spider {

    private String url;
    private String html;


    public Spider(String url){
        this.url = url;
        this.html = HttpUtil.getHtml(url);

        System.out.println(html);

    }



    public List<String> getPhone(String str){

        Pattern pattern = Pattern.compile("1[3|4|5|7|8][0-9]\\d{8}");
        Matcher matcher = pattern.matcher(str);


        List<String> list = new ArrayList<>();
        while (matcher.find()){
            list.add(matcher.group());
        }

        return list;
    }


    List<String> getByRegex(String regex){

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(html);

        List<String> list = new ArrayList<>();
        while (matcher.find()){
            list.add(matcher.group());
        }

        return list;
    }


}
