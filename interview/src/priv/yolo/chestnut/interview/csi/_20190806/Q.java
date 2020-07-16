package priv.yolo.chestnut.interview.csi._20190806;

/**
 * 一、填空题
 * 二、简答题 略
 */
public class Q {

    public static void main(String[] args) {
        // 1. 如果a = 16，那么a >> 3的值为？结果：2
        int a = 16;
        System.out.println(a >> 3);

        // 2. How many times is f() called when calculating f(10)？结果：15
        System.out.println(f(10));

        // 4. 下面这段程序执行后的结果是？结果：aceg
        String s = new String("abcdefg");
        for (int i = 0; i < s.length(); i += 2) {
            System.out.print(s.charAt(i));
        }
        System.out.println();

        // 6. 下面程序的运行结果是？结果是：false(红色的)
        String str1 = "hello";
        String str2 = "he" + new String("llo");
        System.err.println(str1 == str2);

        // 7. ArrayList list = new ArrayList(20);中的list扩充（）次？ 答案：0次

        // 8. final 修饰的变量不能被（），final修饰的类不能被（），final修饰的方法不能被（）？
        // 答案：修改、继承、覆写

        // 9. 整形数据类型中，需要内存空间最少的是（）？答案：int

        // 10.Java语言具有许多优点和特点，（）反应Java程序并行机制的特点. 答案：多线程

        // 11.Math.random()可以产生一个在0和1之间的数，请写出一个在125-175之间的整数的语句（）？
        // int random = m + （int）(Math.random() * (n - m));        // 生成从m到n的随机整数[m, n)
        // int random = m + （int）(Math.random() * (n - m + 1));    // 生成从m到n的随机整数[m, n]
        // ps：注意右区间是否闭合！
        int random = 125 + (int) (Math.random() * (175 - 125 + 1));
        System.out.println(random);
    }

    private static int f(int x) {
        if (x <= 2) {
            return 1;
        }

        return f(x - 2) + f(x - 4) + 1;
    }

}
