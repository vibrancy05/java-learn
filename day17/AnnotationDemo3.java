package day17;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

public class AnnotationDemo3 {
    @Test
    public void parseClass() throws Exception{
        Class c1 = Demo.class;
        if(c1.isAnnotationPresent(MyTest2.class)){
            MyTest2 mt = (MyTest2) c1.getDeclaredAnnotation(MyTest2.class);
            System.out.println(mt.value());
            System.out.println(mt.aaa());
            System.out.println(Arrays.toString(mt.bbb()));
        }
    }
    @Test
    public void parseMethod() throws Exception{
        Class c1 = Demo.class;
        Method[] methods = c1.getDeclaredMethods();
        for(Method m : methods){
            if(m.isAnnotationPresent(MyTest2.class)){
                MyTest2 mt = m.getDeclaredAnnotation(MyTest2.class);
                System.out.println(mt.value());
                System.out.println(mt.aaa());
                System.out.println(Arrays.toString(mt.bbb()));
            }
        }
    }
}
