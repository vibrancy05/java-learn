package day5;

public class PriceDiscountCoupon implements Coupon {
    private int threshold;
    private int discount;
    public PriceDiscountCoupon(int threshold, int discount)
    {
        this.threshold = threshold;
        this.discount = discount;
    }
    @Override
    public int calculateDiscount(double totalPrice){
        return totalPrice>=threshold?discount:0;
    }
}
