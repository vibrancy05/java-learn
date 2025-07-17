package day4;

public class MemoryAllocation {
    public static void main(String[] args) {
        //1.基本数据类型，不产生关联
        int a = 10;
        int b = a;
        System.out.println(b);//10
        b = 20;
        System.out.println(a);//10
        System.out.println(b);//20
        System.out.println("-----------------------------");
        //2.引用数据类型，产生关联
        Object_Oriented obj = new Object_Oriented();
        obj.name = "张三";
        System.out.println(obj.name);
        Object_Oriented obj2 = obj;
        System.out.println(obj2.name);
        obj2.name = "李四";
        System.out.println(obj.name);//李四
        System.out.println(obj2.name);//李四
        System.out.println(obj == obj2);
        System.out.println(obj.equals(obj2));
        System.out.println(obj.hashCode());
        System.out.println(obj2.hashCode());
        System.out.println("-----------------------------");
        /*引用数据类型指向堆内存中的对象，赋值时传递的是对象的地址。
        因此，obj2 = obj 使 obj 和 obj2 指向同一个对象，
        修改其中任何一个引用的属性都会反映到另一个引用上。*/

    }
}
