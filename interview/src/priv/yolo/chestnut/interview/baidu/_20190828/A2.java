package priv.yolo.chestnut.interview.baidu._20190828;

import java.util.Stack;

/**
 * 自定义队列，实现线程安全的先进先出功能。要求，通过两个栈来实现。
 */
public class A2 {

    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);

        System.out.println(myQueue.remove());

        myQueue.add(4);

        for (int i = 0; i < 3; i++) {
            System.out.println(myQueue.remove());
        }
    }

}

// 参考链接：https://blog.csdn.net/qichangleixin/article/details/76091717
// 扩展链接：https://blog.csdn.net/jsc123581/article/details/81986714
class MyQueue<T> {
    // 存放入队数据，入队栈
    private Stack<T> addS = new Stack<>();
    // 存放出队数据，出队栈
    private Stack<T> removeS = new Stack<>();

    // 数据入队方法，直接往入队栈中压入数据
    synchronized void add(T t) {
        addS.push(t);
    }

    // 数据出队方法
    synchronized T remove() {
        // 第1次，如果出队栈为空，则将入队栈数据出栈，再压入出队栈中
        // 其余，当每次出队栈中数据出栈完毕，会将入队栈中的数据压入出队栈中
        // 栈：先进后出
        // 队列：先进先出
        // 经过此步骤，顺序符合先进先出
        if (removeS.isEmpty()) {
            while (!addS.isEmpty()) {
                removeS.push(addS.pop());
            }
        }

        // 出队栈不为空，从出队栈中出栈
        if (!removeS.isEmpty()) {
            return removeS.pop();
        }

        return null;
    }

}
