package day5;
//演示面向对象中继承思想(父类)
public abstract class Product {
    private String name;
    private double price;

    public Product() {
        System.out.println("父类无参构造方法");
    }

    public abstract void sendProduct() ;



    public Product(String name, double price) {
        System.out.println("父类有参构造方法");
        this.name = name;
        this.price = price;
    }

    public String displayInfo(){
        return "商品名称："+name+"  商品价格："+price + "元";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
