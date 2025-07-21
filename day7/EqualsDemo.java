package day7;

public class EqualsDemo {
    public static void main(String[] args) {
        Student s1 = new Student("张三", 18);
        Student s2 = new Student("张三", 18);
        // 判断两个对象是否相等（查询地址）
        System.out.println(s1 == s2);
        // 调用Student类中自定义的equals方法
        System.out.println(s1.equals(s2));
    }
}
