package day4;

public class Polymorphism_Demo {
    public static void main(String[] args) {
        //父类类型的变量指向子类对象，JVM会自动将子类对象转换成父类对象，向上转型
        Entity_Product p = new Entity_Product("鼠标", 200.00, 100);
        Digital_Product d = new Digital_Product("流量卡", 50.00, "123456");

        createOrder(p);
        createOrder(d);
    }
    //同一事物处理多种形态的对象，称为多态
    public static void createOrder(Product product) {
        //1.展示商品信息
        System.out.println(product.displayInfo());
        //2.生成订单
        System.out.println("生成订单成功！");
    }
}
