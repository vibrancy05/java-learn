package day8;

public class AutoBoxingDemo {
    public static void main(String[] args) {
        // 自动装箱
        Integer i1 = 10;
        Integer i2 = 200;
        System.out.println(i1.doubleValue());
        Boolean b = true;
        System.out.println(b);
        System.out.println(b.booleanValue());
        // 自动拆箱
        int j=i1;

        System.out.println(j+100);
        System.out.println(j>=200);
        Integer k1=10;
        Integer k2=200;
        System.out.println(i1==k1);//缓存机制调用valueOf(),返回true
        System.out.println(i2==k2);//不触发自动拆箱，返回false
        //如果包装类是null，自动拆箱会报空指针异常
    }
}
