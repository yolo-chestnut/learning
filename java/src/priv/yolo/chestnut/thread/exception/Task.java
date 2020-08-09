package priv.yolo.chestnut.thread.exception;

public class Task implements Runnable {

    private final int i;

    public Task(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        if (i == 5) {
            // Exception包含RuntimeException和Checked Exception
            // RuntimeException 运行时异常，不受检查异常
            // Checked Exception 受检查的异常，必须做处理，否则编译器报错，不予通过
            throw new RuntimeException(threadName + "，抛出一个异常！");
        }
        System.out.println(threadName + "：" + i);
    }

}
