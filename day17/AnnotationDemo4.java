package day17;

import java.lang.reflect.Method;

public class AnnotationDemo4 {
    public static void main(String[] args) throws Exception {
        AnnotationDemo4 ad = new AnnotationDemo4();
        Class c = AnnotationDemo4.class;
        Method[] methods = c.getDeclaredMethods();
        for(Method m : methods){
            if(m.isAnnotationPresent(MyTest1.class)){
                MyTest1 mt = m.getDeclaredAnnotation(MyTest1.class);
                for(int i = 0; i < mt.count(); i++){
                    m.invoke(ad);
                }
            }
        }
    }
    @MyTest1(count = 5)
    public void test1(){
        System.out.println("test1()");
    }
    public void test2(){
        System.out.println("test2()");
    }
    @MyTest1
    public void test3(){
        System.out.println("test3()");
    }
    public void test4(){
        System.out.println("test4()");
    }
}
