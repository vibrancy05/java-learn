package day14;

import static java.lang.Long.MAX_VALUE;

public class MyRunnable implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("线程" + Thread.currentThread().getName() + "正在运行" + i);
            if(i==0){
                try {
                    Thread.sleep(MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
