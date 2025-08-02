package day12;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class CommonsIODemo {
    public static void main(String[] args) throws IOException {
        FileUtils.copyFile(new File("D:\\Java-code\\day12\\src\\day12\\1.txt"),new File("D:\\Java-code\\day12\\src\\day12\\4.txt"));
    }
}
