package day14;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo3 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        ExecutorService pool2 = Executors.newSingleThreadExecutor();
        ExecutorService pool3 = Executors.newCachedThreadPool();
        pool.submit(new MyRunnable());
        pool2.submit(new MyRunnable());
        pool3.submit(new MyRunnable());
    }
}
