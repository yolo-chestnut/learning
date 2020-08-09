package priv.yolo.chestnut.thread.exception;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<String> {

    private final int i;

    public CallableTask(int i) {
        this.i = i;
    }

    @Override
    public String call() throws Exception {
        String threadName = Thread.currentThread().getName();
        if (i == 5) {
            throw new Exception(threadName + "，抛出一个异常！");
        }
        System.out.println(threadName + "：" + i);

        return threadName + "，success";
    }

}
