package priv.yolo.chestnut.thread.exception;

public class ThreadTest {

    public static void main(String[] args) {
        // 线程内捕获异常--方法1 设置默认defaultUncaughtExceptionHandler（这是个static变量）
        Thread.setDefaultUncaughtExceptionHandler(new MyDefaultThreadExceptionHandler());

        try {
            for (int i = 0; i < 10; i++) {
                String threadName = "thread-" + i;
                new Thread(new Task(i), threadName).start();
            }

            // 线程内捕获异常--方法2 设置自定义uncaughtExceptionHandler
            Thread thread = new Thread(new Task(5), "test");
            thread.setUncaughtExceptionHandler(
                    (t, e) -> System.out.println("customizeThreadException--" + Thread.currentThread().getName() + "：" + e)
            );
            thread.start();

            // 线程内捕获异常--方法3 设置线程组
            new Thread(new MyThreadGroup("方法3"), new Task(5)).start();

            /*
            总结：优先级 方法2 > 方法3 (若线程组还有父线程组，则优先父线程组) > 方法1 > 不做任何设定，在控制台上输出err信息
             */
        } catch (Exception e) {
            // 主线程无法捕获线程内异常
            System.out.println(Thread.currentThread().getName() + e);
            e.printStackTrace();
        }
    }

}
