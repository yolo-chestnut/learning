package priv.yolo.chestnut.interview.botbrain._20190805;

import java.io.File;
import java.util.Scanner;

public class Q {

    public static void main(String[] args) {
        // 1. 有下面程序，输出结果为？
        // 1.1
        String str1 = "hello";
        String str2 = "hello";
        String str3 = new String("hello");
        System.out.println(str1 == str2);       // true
        System.out.println(str1 == str3);       // false
        // 1.2
        StringBuffer sb1 = new StringBuffer("abc");
        StringBuffer sb2 = new StringBuffer("abc");
        StringBuffer sb3 = sb1;
        System.out.println(sb1.equals(sb2));    // false ps:StringBuffer没有重写equals方法！！！
        System.out.println(sb1 == sb2);         // false
        System.out.println(sb1.equals(sb3));    // true
        System.out.println(sb1 == sb3);         // true

        // 2. Java创建对象有哪些种方式？

        // 3. 下面的方法，当输入为2的时候返回值是多少？
        int i = 2;
        System.out.println(getValue(i));        // 10

        // 4. 在JavaEE中，初始化Servlet实例的时候，init()方法是由（C）执行？
        // A. 程序员编写代码来调用执行
        // B. 每次执行当前的Servlet时，由系统自动执行
        // C. 当第一次执行当前的Servlet时，由系统自动执行
        // D. 以上说法都不对

        // 5. 0.6332的数据类型是(B)
        // A float
        // B double
        // C Float
        // D Double

        // 6. 常用排序算法有哪些？写一个你认为比较合适（效率高）的排序算法对{32, 42, 12, 9, 98, 45, 2, 0 ,99}进行排序

        // 8. 从键盘输入接收一个文件夹路径，打印出该文件夹下所有的.java文件名 要求：递归实现
        Scanner in = new Scanner(System.in);
        String filePath = in.nextLine();
        findAllFileEndsWithJava(filePath);

        // 9. 生产者--消费者，用java多线程写一个生产者消费者模式的代码
        // 详见PCModel
    }

    // 2
    private static int getValue(int i) {
        int result = 0;
        switch (i) {
            case 1:
                result = result + i;
            case 2:
                result = result + i * 2;
            case 3:
                result = result + i * 3;
        }
        return result;
    }

    // 8
    private static void findAllFileEndsWithJava(String filePath) {
        File file = new File(filePath);

        if (file.exists()) {
            File[] files = file.listFiles();
            if (files == null || files.length == 0) {
                System.out.println(file.getAbsolutePath() + "，这是一个空文件夹");
            } else {
                for (File fs : files) {
                    if (fs.isDirectory()) {
                        findAllFileEndsWithJava(fs.getAbsolutePath());
                    }
                    if (fs.isFile() && fs.getName().endsWith(".java")) {
                        System.out.println(fs.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("输入有误！");
        }
    }

}
