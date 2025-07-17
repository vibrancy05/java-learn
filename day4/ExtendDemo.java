package day4;

public class ExtendDemo {
    public static void main(String[] args)
    {
        Entity_Product p = new Entity_Product("手机", 5000.00, 672.00);
        System.out.println(p.displayInfo());
        //实体类继承了抽象类Product，所以实体类对象也可以调用抽象类中的方法
        Digital_Product p1 = new Digital_Product("显卡", 8000.00, "123456");
        System.out.println(p1.displayInfo());
    }

}
