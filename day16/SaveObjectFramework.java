package day16;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

public class SaveObjectFramework {
    public static void saveObject(Object obj) throws IllegalAccessException, FileNotFoundException {
        PrintStream ps= new PrintStream(new FileOutputStream("src/day16/obj.txt", true));
        Class c =obj.getClass();
        String simpleName = c.getSimpleName();
        ps.println(simpleName);
        Field[] fields = c.getDeclaredFields();
        for (Field f : fields) {
            String fieldName = f.getName();
            String fieldValue = "";
            f.setAccessible(true);
            fieldValue = f.get(obj).toString();
            ps.println(fieldName + "=" + fieldValue);
        }
        System.out.println("写入信息成功");
        ps.close();
    }
}
