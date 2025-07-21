package day8;

import java.io.IOException;

public class CatchDemo {
    public static void main(String[] args){
        try {
            PersonalStorage ps = new PersonalStorage();
            String content = ps.readFileWithThrows("D:\\a.txt");
            System.out.println(content);
        } catch (IOException e) {
            System.out.println("文件不存在");
        }
    }
}
