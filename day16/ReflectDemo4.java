package day16;

public class ReflectDemo4 {
    public static void main(String[] args) throws Exception {
        Student s = new Student("张三", 18, 90.0);
        SaveObjectFramework.saveObject(s);
        Student s1 = new Student("张三",19,100);
        SaveObjectFramework.saveObject(s1);
        Student s2 = new Student("李四",20,80);
        SaveObjectFramework.saveObject(s2);

    }
}
