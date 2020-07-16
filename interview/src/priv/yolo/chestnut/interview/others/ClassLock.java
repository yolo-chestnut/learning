package priv.yolo.chestnut.interview.others;

/**
 * 关于类锁、实例锁的一些实验
 */
public class ClassLock implements Runnable {

    static final String lock = "lock";

    void print() {
        System.out.println("调用了实例方法");
    }

    static void print1() {
        System.out.println("调用了类方法");
    }

    @Override
    public void run() {
        synchronized (ClassLock.class) {
            try {
                System.out.println(Thread.currentThread().getName() + "线程，拿到了TestClassLock类锁");
                Thread.sleep(10000);
                System.out.println(Thread.currentThread().getName() + "线程，释放了TestClassLock类锁");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new ClassLock(), "Test线程").start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "线程，测试开始");
        new ClassLock().print();
//        synchronized (TestClassLock.class) {
        ClassLock.print1();
        System.out.println(Thread.currentThread().getName() + "线程，打印了类属性，其值为：" + ClassLock.lock);
//        }
        System.out.println(Thread.currentThread().getName() + "线程，测试结束");
    }

}
