package priv.yolo.chestnut.interview.boss._20181118;

/**
 * 用java多线程模拟一个死锁程序
 */
public class A3 {
    static final String resource1 = "资源1";
    static final String resource2 = "资源2";

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (A3.resource1) {
                System.out.println(Thread.currentThread().getName() + "获取到" + A3.resource1);

                // 使持有资源1的线程睡眠3s，增加持有时间，保证其他线程访问不到
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (A3.resource2) {
                    System.out.println(Thread.currentThread().getName() + "获取到" + A3.resource2);
                }
            }
        }, "测试线程-1").start();

        new Thread(() -> {
            synchronized (A3.resource2) {
                System.out.println(Thread.currentThread().getName() + "获取到" + A3.resource2);
                synchronized (A3.resource1) {
                    System.out.println(Thread.currentThread().getName() + "获取到" + A3.resource1);
                }
            }
        }, "测试线程-2").start();
    }

}
