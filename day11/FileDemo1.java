package day11;

import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileDemo1 {
    public static void main(String[] args) throws IOException {

        //创建File对象查找文件信息
        File f1 = new File("C:\\Users\\Yuyang Wang\\Pictures\\Camera Roll\\QQ图片20240219123840.jpg");
        System.out.println(f1.length());
        System.out.println(f1.getName());
        System.out.println(f1.isFile());
        System.out.println(f1.isDirectory());
        System.out.println(f1.getAbsolutePath());
        System.out.println(f1.getPath());
        //使用相对路径查找文件
        File f2=new File("src\\day11\\1.txt");
        System.out.println(f2.exists());
        System.out.println(f2.length());
        //创建对象代表不存在的文件路径
        File f3=new File("src\\day11\\2.txt");
        System.out.println(f3.exists());
        System.out.println(f3.createNewFile());
        //创建对象代表不存在的文件夹路径
        File f4=new File("src\\day11\\1");
        System.out.println(f4.exists());
        System.out.println(f4.mkdir());
        //删除文件和文件夹
        File f5=new File("src\\day11\\1");
        System.out.println(f5.delete());
        //遍历获取文件夹下的所有文件
        File f6=new File("D:\\Java-code\\day11\\src\\day11");
        String[] names=f6.list();
        for (String name:names){
            System.out.println(name);
        }
        File dir=new File("D:\\Java-code\\day11\\src\\day11");
        File[] files=dir.listFiles();
        System.out.println(Arrays.toString(files));
    }
}
