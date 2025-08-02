package day12;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrintStreamDemo {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream ps=new PrintStream("D:\\Java-code\\day12\\src\\day12\\3.txt");
        ps.println("hello world");
        ps.println(123);
        ps.println(true);
        ps.println(12.34);
        ps.println("这是一段文字");
    }
}
