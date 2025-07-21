package day7;

public class HashcodeDemo {
    public static void main(String[] args)
    {
        Student s1 = new Student("张三", 18);
        Student s2 = new Student("张三", 18);
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}
