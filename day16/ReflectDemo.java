package day16;

public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c1 = Student.class;
        System.out.println(c1);
        Class c2 = Class.forName("day16.Student");
        System.out.println(c2);
        System.out.println(c1==c2);
        Student s = new Student("张三", 18, 90);
        Class c3 = s.getClass();
        System.out.println(c3);
        System.out.println(c1==c3);
    }
}
