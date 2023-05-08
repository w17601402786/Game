package com.game;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Download extends Thread{

        private String url;
        private String path;

        public Download(String url,String path){
            this.url = url;
            this.path = path;
        }

        @Override
        public void run() {

            try {

                InputStream inputStream = HttpUtil.readAsStream(url);


                int i = url.lastIndexOf("/");



                String fileName = url.substring(i+1);

                File file = new File(path,fileName);

                OutputStream os = new FileOutputStream(file);


                byte[] bytes = new byte[1024];
                int len;
                while ((len = inputStream.read(bytes)) != -1){
                    os.write(bytes,0,len);
                }

                os.close();

            }catch (Exception e){
                e.printStackTrace();
            }


        }

}
