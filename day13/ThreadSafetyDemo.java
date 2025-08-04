package day13;

public class ThreadSafetyDemo {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount(1000,123456);
        Thread t1 = new DrawThread("张三",ba);
        Thread t2 = new DrawThread("李四",ba);
        t1.start();
        t2.start();
    }
}
