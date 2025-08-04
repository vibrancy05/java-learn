package day14;

import java.util.concurrent.*;

public class ExecutorDemo2 {
    public static void main(String[] args) {
        ExecutorService executor = new ThreadPoolExecutor(2, 5,
                1000, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(2),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        Future<String> f1=executor.submit(new MyCallable(100));
        Future<String> f2=executor.submit(new MyCallable(200));
        Future<String> f3=executor.submit(new MyCallable(300));
        Future<String> f4=executor.submit(new MyCallable(400));

        try {
            System.out.println(f1.get());
            System.out.println(f2.get());
            System.out.println(f3.get());
            System.out.println(f4.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
