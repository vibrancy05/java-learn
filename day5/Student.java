package day5;

public class Student {
    private static int count = 0;
    private String name;
    private int id;
    private String gender;
    private int age;
    public Student(String name, int id, String gender, int age)
    {
        count++;
        this.name = name;
        this.id = count;
        this.gender = gender;
        this.age = age;
    }
    public void displayInfo()
    {
        System.out.println("姓名：" + name + "，学号：" + id + "，性别：" + gender + "，年龄：" + age);
    }
    public static int getCount()
    {
        return count;
    }
}
