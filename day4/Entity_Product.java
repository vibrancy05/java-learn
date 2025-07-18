package day4;
//演示面向对象中继承思想(子类)
public class Entity_Product extends  Product {
    private double weight;
    public Entity_Product() {
        System.out.println("实体商品子类无参构造方法");
    }

    @Override
    public void sendProduct() {
        System.out.println("正在发送实体商品...");
    }

    public Entity_Product(String name, double price, double weight) {
        super(name, price);
        this.weight = weight;
        System.out.println("实体商品子类有参构造方法");
    }
    public String displayInfo() {
        return super.displayInfo()+"，重量为："+weight+"g";
    }
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
