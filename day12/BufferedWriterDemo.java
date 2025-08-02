package day12;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;

public class BufferedWriterDemo {
    public static void main(String[] args) {
        try (Writer fw = new FileWriter("D:\\Java-code\\day12\\src\\day12\\2.txt");
            BufferedWriter bw = new BufferedWriter(fw))
        {
            bw.write("字符输出流测试");
            bw.newLine();
            bw.write("hello world");
            bw.write(" java");
            bw.newLine();
            char[] chs = {'a', 'b', 'c'};
            bw.write(chs, 0, 2);
            bw.newLine();
            System.out.println("写入完毕");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
