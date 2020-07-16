package priv.yolo.chestnut.interview.botbrain._20190805;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者-消费者模式，实现方法2
 * <p>
 * 比方法1控制更细腻，可以将生产者，消费者分组别唤醒
 */
public class PCModel2 {
    // 产品计数器
    final static AtomicInteger counter = new AtomicInteger(0);
    // 锁
    static Lock lock = new ReentrantLock();
    // 锁 - 条件1 仓库已满（主要放生产者线程）
    static Condition repoFull = lock.newCondition();
    // 锁 - 条件2 仓库已空（主要放消费者线程）
    static Condition repoEmpty = lock.newCondition();

    public static void main(String[] args) {
        Queue<Integer> repo = new LinkedList<>();
        int repoMaxSize = 5;
        new Thread(new Producer2(repo, repoMaxSize), "P1").start();
        new Thread(new Producer2(repo, repoMaxSize), "P2").start();
        new Thread(new Consumer2(repo), "C1").start();
//        new Thread(new Consumer2(repo), "C2").start();
    }

}

class Producer2 implements Runnable {
    // 仓库，用于缓存数据
    private Queue<Integer> repo;
    // 仓库最大存储数量
    private int repoMaxSize;
    // 标志位
    private volatile boolean flag = true;

    Producer2(Queue<Integer> repo, int repoMaxSize) {
        this.repo = repo;
        this.repoMaxSize = repoMaxSize;
    }

    private void produce() {
        String currentThreadName = Thread.currentThread().getName();
        while (flag) {
            PCModel2.lock.lock();
            try {
                System.out.println(currentThreadName + "，获得锁");
                while (repoMaxSize == repo.size()) {
                    System.out.println(currentThreadName + "，仓库已满，生产者暂停，并释放锁");
                    PCModel2.repoFull.await();
                    System.out.println(currentThreadName + "，被唤醒");
                }
                int product = PCModel2.counter.addAndGet(1);
                System.out.println(currentThreadName + "，预计生产产品：" + product);
                repo.offer(product);
                System.out.println(currentThreadName + "，成功生产产品：" + product);
                PCModel2.repoEmpty.signalAll();
                System.out.println(currentThreadName + "，唤醒repoEmpty条件的线程");
                // 测试
                if (PCModel2.counter.get() >= 100000) {
                    flag = false;
                }
            } catch (InterruptedException e) {
                flag = false;
                e.printStackTrace();
            } finally {
                PCModel2.lock.unlock();
            }
            // 为了方便观察
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(currentThreadName + "，结束了一次while循环");
        }
    }

    @Override
    public void run() {
        produce();
    }

}

class Consumer2 implements Runnable {
    // 仓库，用于缓存数据
    private Queue<Integer> repo;
    // 标志位
    private volatile boolean flag = true;

    Consumer2(Queue<Integer> repo) {
        this.repo = repo;
    }

    private void consume() {
        String currentThreadName = Thread.currentThread().getName();
        while (flag) {
            PCModel2.lock.lock();
            try {
                System.out.println(currentThreadName + "，获得锁");
                while (repo.isEmpty()) {
                    System.out.println(currentThreadName + "，仓库为空，消费者暂停，并释放锁");
                    PCModel2.repoEmpty.await();
                    System.out.println(currentThreadName + "，被唤醒");
                }
                int product = repo.poll();
                System.out.println(currentThreadName + "，消费产品：" + product);
                PCModel2.repoFull.signalAll();
                System.out.println(currentThreadName + "，唤醒repoFull条件的线程");
                // 测试
                synchronized (PCModel2.counter) {
                    if (PCModel2.counter.get() >= 10000) {
                        flag = false;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                flag = false;
            } finally {
                PCModel2.lock.unlock();
            }
            // 方便观察
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(currentThreadName + "，结束了一次while循环");
        }
    }

    @Override
    public void run() {
        consume();
    }

}
