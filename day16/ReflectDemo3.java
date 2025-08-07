package day16;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class ReflectDemo3 {
    public static void main(String[] args) throws Exception {
        //反射的好处：绕过泛型约束
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");
        Class c = list.getClass();
        Method add = c.getMethod("add", Object.class);
        add.invoke(list,9.9);
        add.invoke(list,true);
        System.out.println(list);
    }
}
