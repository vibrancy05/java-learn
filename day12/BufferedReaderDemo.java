package day12;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class BufferedReaderDemo {
    public static void main(String[] args) {
        try {
            Reader reader = new FileReader("D:\\Java-code\\day11\\src\\day11\\1.txt");
            BufferedReader br = new BufferedReader(reader);
            //读取单行
            String s = br.readLine();
            while (s != null) {
                System.out.println(s);
                s = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
