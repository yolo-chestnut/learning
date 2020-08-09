package priv.yolo.chestnut.thread.exception;

import java.util.concurrent.*;

public class ThreadFactorTest {

    public static void main(String[] args) {
        // 线程池捕获异常--方法1 设置默认defaultUncaughtExceptionHandler（这是个static变量）
        Thread.setDefaultUncaughtExceptionHandler(new MyDefaultThreadExceptionHandler());
        ExecutorService es = Executors.newFixedThreadPool(6);
        for (int i = 1; i <= 5; i++) {
            es.execute(new Task(i));
        }
        es.shutdown();

        // 线程池捕获异常--方法2 设置自定义ThreadFactory
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 5, 60, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
        threadPool.setThreadFactory(new MyThreadFactory());
        for (int i = 1; i <= 5; i++) {
            threadPool.execute(new Task(i));
        }
        threadPool.shutdown();
    }

}
