package day5;

public class RateDiscountCoupon implements Coupon
{
    private int threshold;
    private int discount;
    public RateDiscountCoupon(int threshold, int discount)
    {
        this.threshold = threshold;
        this.discount = discount;
    }

    @Override
    public int calculateDiscount(double totalPrice) {
        return totalPrice >= threshold ? (int) totalPrice *(100-discount)/100 : 0;
    }

}
