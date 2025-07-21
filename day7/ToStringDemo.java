package day7;

public class ToStringDemo {

    public static void main(String[] args)
    {
        Student s1 = new Student("张三疯", 18);
        System.out.println(s1);
        System.out.println(s1.toString());
        System.out.println(s1.hashCode());
        System.out.println(s1.getClass().getName() + "@" + s1.hashCode());
    }
}
