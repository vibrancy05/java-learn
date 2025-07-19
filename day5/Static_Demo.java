package day5;

public class Static_Demo {
    public static void main(String[] args) {
        Student student1 = new Student("张三", 1, "男", 18);
        Student student2 = new Student("李四", 2, "女", 19);
        Student student3 = new Student("王五", 3, "男", 20);
        Student student4 = new Student("赵六", 4, "女", 21);
        Student student5 = new Student("孙七", 5, "男", 22);
        System.out.println("学生总人数："+ Student.getCount());
        //静态变量随着类的加载而加载，不会随对象而改变
        //使用静态变量无需创建对象，可直接使用类名.变量名访问
        student2.displayInfo();
    }
}
