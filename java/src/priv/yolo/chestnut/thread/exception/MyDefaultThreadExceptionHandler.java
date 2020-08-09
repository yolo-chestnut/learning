package priv.yolo.chestnut.thread.exception;

public class MyDefaultThreadExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        String threadName = Thread.currentThread().getName();
        System.out.println("Default--" + threadName + "：" + e);
    }

}
