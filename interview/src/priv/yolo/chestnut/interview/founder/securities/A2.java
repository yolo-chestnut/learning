package priv.yolo.chestnut.interview.founder.securities;

/**
 * 2. 100的阶乘，尾数有多少个0？写程序实现n的阶乘尾数有多少个0？
 */
public class A2 {

    // 一种规律，但是网上没有严格验证
    public static void main(String[] args) {
        System.out.println(method1(100));
        System.out.println(method2(100));
    }

    // 迭代解法
    private static int method1(int n) {
        int num = 0;

        while (n >= 5) {
            num += n / 5;
            n /= 5;
        }

        return num;

    }

    // 递归解法
    private static int method2(int n) {
        if (n < 5) {
            return 0;
        }

        n /= 5;

        return n + method2(n);

    }

}
