package day11;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class FileOutputStreamDemo {
    public static void main(String[] args) throws IOException
    {
        OutputStream os =new FileOutputStream("src\\day11\\1.txt");
        os.write(97);
        os.write(98);
        os.write(99);
        os.write(100);
        byte[] bytes = "我的字符".getBytes() ;
        os.write(bytes);
        os.write("\r\n".getBytes());
        os.write(bytes,0,bytes.length);
        os.write("\r\n".getBytes());
        os.close();
    }
}
