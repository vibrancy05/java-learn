package day12;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class FileReadersDemo {
    public static void main(String[] args) {
        try {
            Reader reader = new FileReader("D:\\Java-code\\day11\\src\\day11\\1.txt");
            int ch;
            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
