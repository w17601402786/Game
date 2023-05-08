package com.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class HttpUtil {

    public static String getHtml(String httpUrl) {

        StringBuffer buffer = new StringBuffer();



        try {

            URL url = new URL(httpUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            int responseCode = connection.getResponseCode();


            if (responseCode != HttpURLConnection.HTTP_OK) {
                System.out.println("请求失败");
                return "";
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;


            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            reader.close();
            connection.disconnect();

        }catch (Exception e){
            return "";
        }

        return buffer.toString();

    }


    /**
     * 以流读取网页文件
     * @param url 网页地址
     * @return 网页文件的流
     */
    public static InputStream readAsStream(String url) throws IOException {
        URL website = new URL(url);
        URLConnection connection = website.openConnection();
        return connection.getInputStream();
    }

}
