package priv.yolo.chestnut.thread.exception;

import java.util.Objects;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        // 本应该使用@NotNull，但是需要应用框架，sun有，但不推荐使用
        Objects.requireNonNull(r);
        Thread thread = new Thread(r);
        thread.setUncaughtExceptionHandler(
                (t, e) -> System.out.println("customizeThreadFactoryException" + Thread.currentThread().getName() + "：" + e)
        );
        return thread;
    }

}
