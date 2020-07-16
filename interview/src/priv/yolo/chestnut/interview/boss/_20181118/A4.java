package priv.yolo.chestnut.interview.boss._20181118;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 启动3个线程打印递增的数字，线程1先打印1、2、3，然后线程2打印4、5、6，然后线程3打印7、8、9，
 * 接着再由线程1打印10、11、12......以此类推，直到打印到75。
 */
public class A4 {

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Task1(1), "线程1-1").start();
        new Thread(new Task1(2), "线程1-2").start();
        new Thread(new Task1(3), "线程1-3").start();

        Thread.sleep(2000);

        new Thread(new Task2(1), "线程2-1").start();
        new Thread(new Task2(2), "线程2-2").start();
        new Thread(new Task2(3), "线程2-3").start();
    }

}

// lock + condition方法
class Task1 implements Runnable {

    static int num = 0;

    static Lock lock = new ReentrantLock();

    static Condition condition = lock.newCondition();

    private int threadId;

    public Task1(int threadId) {
        this.threadId = threadId;
    }

    @Override
    public void run() {
        Task1.lock.lock();
        try {
            while (Task1.num < 75) {
                if (threadId == Task1.num / 5 % 3 + 1) {
                    for (int i = 0; i < 5; i++) {
                        Task1.num++;
                        System.out.println(Thread.currentThread().getName() + "，打印值：" + Task1.num);
                    }
                    // ps：区别
                    Task1.condition.signalAll();
                } else {
                    try {
                        // ps：区别
                        Task1.condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } finally {
            Task1.lock.unlock();
        }
    }

}

// synchronized代码块方法
class Task2 implements Runnable {

    static final AtomicInteger num = new AtomicInteger(0);

    private int threadId;

    public Task2(int threadId) {
        this.threadId = threadId;
    }

    @Override
    public void run() {
        synchronized (Task2.num) {
            while (Task2.num.get() < 75) {
                if (threadId == Task2.num.get() / 5 % 3 + 1) {
                    for (int i = 0; i < 5; i++) {
                        Task2.num.addAndGet(1);
                        System.out.println(Thread.currentThread().getName() + "，打印值：" + Task2.num.get());
                    }
                    // ps：区别
                    Task2.num.notifyAll();
                } else {
                    try {
                        // ps：区别
                        Task2.num.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
