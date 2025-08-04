package day14;

import java.util.concurrent.*;

public class ExecutorDemo1 {
    public static void main(String[] args) {
        // 创建线程池
        ExecutorService pool = new ThreadPoolExecutor(2, 5,
                1000, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(2),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        //使用线程池执行任务，观察复用情况
        Runnable task = new MyRunnable();
        pool.execute(task);
        pool.execute(task);
        pool.execute(task);
        pool.execute(task);
        pool.execute(task);
    }
}
