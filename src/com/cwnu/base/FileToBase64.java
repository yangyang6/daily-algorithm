package com.cwnu.base;

import com.alibaba.fastjson.JSON;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

/**
 * Created by rey on 2019-12-23.
 */
public class FileToBase64 {
    public static void main(String[] args) throws IOException {
        String filePath = "/Users/yangli/Downloads/c522b15ccdea4ee58b61f5dc4927d615.jpeg";
        byte[] b = Files.readAllBytes(Paths.get(filePath));


//        String base64Str = Base64.getEncoder().encodeToString(b);
//        System.out.println(base64Str.length());
//
//        base64ToFile(base64Str);


        System.out.println(JSON.toJSONString(b));

    }


    public static File base64ToFile(String base64) {
        if(base64==null||"".equals(base64)) {
            return null;
        }
        byte[] buff=Base64.getDecoder().decode(base64);
        File file=null;
        FileOutputStream fout=null;
        try {
            file = File.createTempFile("/Users/yangli/Downloads/tmp.jpg", null);
            fout=new FileOutputStream(file);
            fout.write(buff);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fout!=null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return file;
    }
}
