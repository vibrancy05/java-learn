package day4;

public class Digital_Product extends  Product {
    private String secretKey;
    public Digital_Product()
    {
        System.out.println("虚拟商品子类无参构造方法");
    }
    public Digital_Product(String name, double price, String secretKey)
    {
        super(name, price);
        this.secretKey = secretKey;
        System.out.println("虚拟商品子类有参构造方法");
    }

    @Override
    // 标记重写父类的方法
    public String displayInfo() {
        return super.displayInfo()+"，密钥为：******";
    }
}
