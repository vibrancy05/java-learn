package day13;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable1=new MyCallable(100);
        FutureTask<String> task1=new FutureTask<>(callable1);
        Thread t1=new Thread(task1);
        t1.start();
        Callable< String> callable2=new MyCallable(200);
        FutureTask<String> task2=new FutureTask<>(callable2);
        Thread t2=new Thread(task2);
        t2.start();
        try{
            //如果主线程发现第一个线程还没有结束，则主线程会阻塞，等待
        System.out.println(task1.get());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try{
            System.out.println(task2.get());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
class MyCallable implements Callable<String> {
    private int n;

    public MyCallable(int n) {
        this.n=n;
    }
    @Override
    public String call() throws Exception {
        int num=0;
        for (int i = 0; i < n; i++) {
            System.out.println(i);
            num+=i;

        }
        return "子线程的计算结果是"+num;
    }
}