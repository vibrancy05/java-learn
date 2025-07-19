package day5;

import day4.Entity_Product;
import day4.Product;

public class InterFaceDemo {
    public static void main(String[] args) {
        //1.展示满减券的使用
        Product p= new Entity_Product("鼠标", 200.00, 50.00);
        Coupon coupon1 = new PriceDiscountCoupon(100, 10);
        //构造函数注入
        Order order = new Order(p, 1, coupon1);
        order.showOrderInfo();
        //2.展示折扣券的使用
        System.out.println("----------------------------------");
        Coupon coupon2 = new RateDiscountCoupon(100, 85);
        //setter 注入
        order.setCoupon(coupon2);
        order.showOrderInfo();

    }
}
