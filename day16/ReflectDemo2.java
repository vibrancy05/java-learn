package day16;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectDemo2 {
    @Test
    public void getClassInfo() {
        Class c1 = Student.class;
        System.out.println(c1.getName());
        System.out.println(c1.getSimpleName());
    }
    @Test
    public void getConstructorInfo() throws Exception {
        Class c1 = Student.class;
        System.out.println(c1.getDeclaredConstructor());
        System.out.println(c1.getDeclaredConstructor(String.class));
        for( Constructor c : c1.getDeclaredConstructors()){
            System.out.println(c);
        }
        Constructor c = c1.getDeclaredConstructor();
        Constructor c2 = c1.getDeclaredConstructor(String.class, int.class, double.class);
        c.setAccessible(true);
        Student s = (Student) c.newInstance();
        System.out.println(s);
        c2.setAccessible( true);
        Student s2 = (Student) c2.newInstance("张三", 18, 90);
        System.out.println(s2);

    }
    @Test
    public void getFieldInfo() throws Exception {
        Class c1 = Student.class;
        Field field = c1.getDeclaredField("name");
        Field[] fields = c1.getDeclaredFields();
        for( Field f : fields){
            System.out.println(f);
        }
        System.out.println(c1.getDeclaredField("name"));
        System.out.println(c1.getDeclaredField("age"));
        Student s = new Student("张三", 18, 90);
        field.setAccessible(true);
        field.set(s, "李四");
        System.out.println(s);
    }
    @Test
    public void getMethodInfo() throws Exception {
        Class c1 = Student.class;
        Method m1 = c1.getDeclaredMethod("show");
        for( Method m : c1.getDeclaredMethods()){
            System.out.println(m.getName()+" "+m.getReturnType()+" "+ Arrays.toString(m.getParameterTypes()));
        }
        m1.setAccessible(true);
        m1.invoke(new Student("张三", 18, 90));
        System.out.println(m1.invoke(new Student("张三", 18, 90)));
    }
}
