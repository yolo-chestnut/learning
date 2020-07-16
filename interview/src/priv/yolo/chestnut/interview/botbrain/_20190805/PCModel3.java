package priv.yolo.chestnut.interview.botbrain._20190805;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class PCModel3 {

    static final AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        int repoMaxSize = 6;
        LinkedBlockingDeque<Integer> repo = new LinkedBlockingDeque<>(repoMaxSize);
        new Thread(new Producer3(repo), "P1").start();
//        new Thread(new Producer3(repo), "P2").start();
        new Thread(new Consumer3(repo), "C1").start();
        new Thread(new Consumer3(repo), "C2").start();
    }

}

class Producer3 implements Runnable {

    private LinkedBlockingDeque<Integer> repo;

    private volatile boolean flag = true;

    Producer3(LinkedBlockingDeque<Integer> repo) {
        this.repo = repo;
    }

    private void produce() {
        String currentThreadName = Thread.currentThread().getName();
        while (flag) {
            try {
                int product = PCModel3.counter.addAndGet(1);
                repo.put(product);
                System.out.println(currentThreadName + "，生产产品：" + product);
                // 测试
//                synchronized (PCModel3.counter) {
                if (product >= 10000) {
                    flag = false;
                }
//                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                flag = false;
            }
        }
    }

    @Override
    public void run() {
        produce();
    }

}

class Consumer3 implements Runnable {

    private LinkedBlockingDeque<Integer> repo;

    private volatile boolean flag = true;

    Consumer3(LinkedBlockingDeque<Integer> repo) {
        this.repo = repo;
    }

    private void consume() {
        String currentThreadName = Thread.currentThread().getName();
        while (flag) {
            try {
                Integer product = repo.take();
                System.out.println(currentThreadName + "，消费产品：" + product);
                // 测试
//                synchronized (PCModel3.counter) {
                if (product >= 10000) {
                    flag = false;
                }
//                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                flag = false;
            }
        }
    }

    @Override
    public void run() {
        consume();
    }

}
