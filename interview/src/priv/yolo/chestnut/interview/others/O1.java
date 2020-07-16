package priv.yolo.chestnut.interview.others;

/**
 * 零散知识点收集
 */
public class O1 {

    public static void main(String[] args) {
        // 跟谁学
        // 自动拆箱装箱 精度问题
        int a = 10;
        int b = 3;
        double c = a / b;
        System.out.println(c);  // 3.0

        // 中软国际
        // char数组输出的内容是字符串不是内存地址！
        // 解释：https://www.jb51.net/article/107132.htm
        char[] charArray = {'1', '2', '3', '4'};
        System.out.println(charArray);  // 输出1234，并不是内存地址哎！

        // 统计字符串2的个数
        int num = 0;
        String s = "1222223456";
        for (char c1 : s.toCharArray()) {
            if (c1 == '2') num++;
        }

        // 阿里规约 字符串类型 需要验证是否为null
        // 结果直接抛异常 NullPointerException
//        aliTest(null);

        // 如何输出 second
        ifTest(-1);

        foo(0);
        foo(1);
        System.out.println(O1.s); // 1323

    }

    private static void aliTest(String param) {
        switch (param) {
            // 肯定不是进入这里
            case "sth":
                System.out.println("it's sth");
                break;
            // 也不是进入这里
            case "null":
                System.out.println("it's null");
                break;
            // 也不是进入这里
            default:
                System.out.println("default");
        }
    }

    private static void ifTest(int x) {
        if (x > 0) {
            System.out.println("first");
        } else if (x > -3) {
            System.out.println("second");
        } else {
            System.out.println("three");
        }
    }

    private static String s = "";

    private static void foo(int i) {
        try {
            if (i == 1) {
                throw new Exception();
            }
            s += "1";
        } catch (Exception e) {
            s += "2";
        } finally {
            s += "3";
        }
    }

}
