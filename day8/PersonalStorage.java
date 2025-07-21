package day8;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PersonalStorage implements PersonalStorageImpl {
    @Override
    public String readFile(String fileName){
        //异常处理，使程序不会中断
        try {
            FileReader fr = new FileReader(fileName);
            System.out.println("开始读取文件");
            int ch = fr.read();
        } catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("结束读取文件");
        return"";

    }
    @Override
    public String readFileWithThrows(String fileName)throws  IOException{
        //异常处理，使程序不会中断
        if(fileName==null||fileName.isBlank()){
            throw new IllegalArgumentException("文件名不能为空");
        }
        try {
            FileReader fr = new FileReader(fileName);
            System.out.println("开始读取文件");
            int ch = fr.read();
        } catch(IOException e){
            System.out.println(e.getMessage());
            throw e;
        }
        System.out.println("结束读取文件");
        return"";

    }
}

