package day13;

import static java.lang.Thread.sleep;

public class ThreadAPIDemo2 {
    public static void main(String[] args) {
        Thread t1 = new MyThread();
        t1.setName("线程1");
        t1.start();
        System.out.println("t1的线程名：" + t1.getName());
        for(int i = 0; i < 10; i++){
            System.out.println("主线程："+ i);
            if(i == 5){
                try{
                    t1.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            if(i>=7){
                try{
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }
}
