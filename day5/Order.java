package day5;

import day4.Product;

public class Order {
    private Product product;
    private int amount;
    private Coupon Coupon;
    public Order(Product product, int amount,Coupon coupon){
        this.product = product;
        this.amount = amount;
        this.Coupon =  coupon;
    }
    public void showOrderInfo(){
        double totalPrice = product.getPrice() * amount;
        int discount = Coupon.calculateDiscount(totalPrice);
        System.out.println("商品名称："+product.getName()+"，单价："+product.getPrice()+"，数量："+amount+"，原价："+totalPrice+"，优惠："+discount+"，实付："+(totalPrice-discount));
        System.out.println("订单构建完成！");
    }

    public void setCoupon(Coupon coupon) {
        this.Coupon = coupon;
    }
}
