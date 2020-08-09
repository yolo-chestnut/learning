package priv.yolo.chestnut.thread.exception;

import java.util.concurrent.FutureTask;

public class CallableThreadTest {

    public static void main(String[] args) {
        // 此方法无效
        Thread.setDefaultUncaughtExceptionHandler(new MyDefaultThreadExceptionHandler());
        for (int i = 0; i < 6; i++) {
            FutureTask<String> futureTask = new FutureTask<>(new CallableTask(i));
            Thread thread = new Thread(futureTask);
            thread.setUncaughtExceptionHandler((t, e) -> {
                // 此方法无效
                System.out.println("自定义--" + Thread.currentThread().getName() + "：" + e);
            });
            thread.start();

            // Callable需要try catch住futureTask.get()，才能捕获异常
            // 因为FutureTask的run方法捕获了异常，所以JVM不会调用Thread的dispatchUncaughtException方法
            try {
                System.out.println(futureTask.get());
            } catch (Exception e) {
                System.out.println("Callable--" + Thread.currentThread().getName() + "：" + e);
            }
        }
    }

}
