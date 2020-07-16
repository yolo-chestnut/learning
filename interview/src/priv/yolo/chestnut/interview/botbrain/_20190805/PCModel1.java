package priv.yolo.chestnut.interview.botbrain._20190805;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者-消费者模式，实现方法1
 */
public class PCModel1 {

    static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        Queue<Integer> repo = new LinkedList<>();
        int repoMaxSize = 6;
        new Thread(new Producer1(repo, repoMaxSize), "P1").start();
        new Thread(new Producer1(repo, repoMaxSize), "P2").start();
        new Thread(new Consumer1(repo), "C1").start();
//        new Thread(new Consumer1(repo), "C2").start();
    }

}

class Producer1 implements Runnable {

    private final Queue<Integer> repo;

    private int repoMaxSize;

    private volatile boolean flag = true;

    Producer1(Queue<Integer> repo, int repoMaxSize) {
        this.repo = repo;
        this.repoMaxSize = repoMaxSize;
    }

    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();
        while (flag) {
            synchronized (repo) {
                try {
                    System.out.println(currentThreadName + "，获得锁并进入同步代码块");
                    while (repoMaxSize == repo.size()) {
                        System.out.println(currentThreadName + "，仓库已满，生产者暂停，并释放锁");
                        repo.wait();
                        System.out.println(currentThreadName + "，被唤醒");
                    }
                    int product = PCModel1.counter.addAndGet(1);
                    System.out.println(currentThreadName + "，预计生产产品：" + product);
                    repo.add(product);
                    System.out.println(currentThreadName + "，成功生产产品：" + product);
                    repo.notifyAll();
                    System.out.println(currentThreadName + "，唤醒其它线程");
                    // 测试用
                    if (PCModel1.counter.get() >= 100000) {
                        flag = false;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    flag = false;
                }
                System.out.println(currentThreadName + "，释放锁并结束同步代码块");
            }

            // 为了方便观察
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(currentThreadName + "，结束了一次while循环");
        }
    }

}

class Consumer1 implements Runnable {

    private final Queue<Integer> repo;

    private volatile boolean flag = true;

    Consumer1(Queue<Integer> repo) {
        this.repo = repo;
    }

    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();
        while (flag) {
            synchronized (repo) {
                try {
                    System.out.println(currentThreadName + "，获得锁并进入同步代码块");
                    while (repo.isEmpty()) {
                        System.out.println(currentThreadName + "，仓库为空，消费者暂停，并释放锁");
                        repo.wait();
                        System.out.println(currentThreadName + "，被唤醒");
                    }
                    int product = repo.poll();
                    System.out.println(currentThreadName + "，消费产品：" + product);
                    repo.notifyAll();
                    System.out.println(currentThreadName + "，唤醒其它线程");
                    // 测试用
                    if (PCModel1.counter.get() >= 100000) {
                        flag = false;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    flag = false;
                }
                System.out.println(currentThreadName + "，释放锁并结束同步代码块");
            }

            // 方便观察
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(currentThreadName + "，结束了一次while循环");
        }
    }

}
