package day12;

import java.io.*;

public class DecodeDemo {
    public static void main(String[] args)
    {
        try(InputStream fis = new FileInputStream("D:\\Java-code\\day12\\src\\day12\\1.txt");
            //Reader isr = new InputStreamReader(fis,"GBK");
            Reader isr = new InputStreamReader(fis,"UTF-8");
            BufferedReader br= new BufferedReader(isr))
        {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
