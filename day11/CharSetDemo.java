package day11;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class CharSetDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String name ="我的字符abc666";
        byte[] bytes = name.getBytes("GBK");
        System.out.println(bytes.length);
        System.out.println(Arrays.toString( bytes));
        System.out.println(new String(bytes));
        System.out.println(new String(bytes,"GBK"));
    }
}
