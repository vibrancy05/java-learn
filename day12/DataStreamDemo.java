package day12;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataStreamDemo {
    public static void main(String[] args)
    {
        try(DataInputStream dis =new DataInputStream(new FileInputStream("D:\\Java-code\\day12\\src\\day12\\1.txt"))){
            while(dis.available()>0){
                System.out.println(dis.readByte());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
