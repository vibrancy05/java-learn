package day13;

public class ThreadTest {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        //mt.run();
        mt.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程："+i);
        }
    }
}
class MyThread extends Thread{
    public MyThread() {

    }

    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+" 子线程输出："+i);
        }
    }
}
