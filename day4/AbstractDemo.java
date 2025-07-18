package day4;

public class AbstractDemo {
    public static void main(String[] args) {
        Digital_Product p = new Digital_Product();
        p.setName("优惠券");
        p.setPrice(88.00);
        System.out.println(p.displayInfo());
        p.sendProduct();
        Entity_Product q = new Entity_Product();
        q.setName("电脑");
        q.setPrice(5000.00);
        q.setWeight(700.00);
        System.out.println(q.displayInfo());
        q.sendProduct();
    }
}
