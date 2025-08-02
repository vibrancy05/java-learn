package day12;

import java.io.BufferedInputStream;
import java.io.FileWriter;
import java.io.Writer;

public class FileWriterDemo {
    public static void main(String[] args) {
        try(Writer fw = new FileWriter("D:\\Java-code\\day12\\src\\day12\\1.txt")) {
            fw.write("字符输出流测试");
            fw.write("\r\n");
            fw.write("hello world");
            fw.write(" java");
            fw.write("\r\n");
            char[] chs = {'a', 'b', 'c'};
            fw.write(chs, 0, 2);
            fw.write("\r\n");
            System.out.println("写入完毕");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
