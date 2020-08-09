package priv.yolo.chestnut.thread.exception;

public class MyThreadGroup extends ThreadGroup {

    // 父类没有无参构造方法
    public MyThreadGroup(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
//        super.uncaughtException(t, e);
        System.out.println("customizeThreadGroupException--" + Thread.currentThread().getName() + "：" + e);
    }

}
