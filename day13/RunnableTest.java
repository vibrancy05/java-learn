package day13;

public class RunnableTest {
    public static void main(String[] args) {
        Runnable r = new MyRunnable();
        Thread t = new Thread(r);
        t.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程：" + Thread.currentThread().getName() + "运行" + i);
        }
    }
}
class MyRunnable implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("子线程1：" + Thread.currentThread().getName() + "运行" + i);
        }
    }
}


