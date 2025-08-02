package day11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException {
        InputStream is=new FileInputStream("src\\day11\\1.txt");
        byte []buffer = new byte[6];
        int len;
        while((len=is.read(buffer))!=-1){
            String s = new String(buffer,0,len);
            System.out.println(new String(s));
        }
        //使用FileInputStream读取文件每次读取一个字节，读取汉字时，会乱码
        byte[]bytes=is.readAllBytes();
        String rs = new String(bytes);
        System.out.println(rs);
        is.close();

        }
    }

