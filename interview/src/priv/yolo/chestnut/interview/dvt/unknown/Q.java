package priv.yolo.chestnut.interview.dvt.unknown;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

public class Q {

    public static void main(String[] args) {
        // 1
        String s1 = new String("abc");
        String s2 = s1.intern();
        String s3 = "abc";
        String s4 = "a" + "bc";

        System.out.println("第1题：");
        System.out.println(s1 == s2);   // false
        System.out.println(s2 == s3);   // true
        System.out.println(s3 == s4);   // true

        // 2 新建一个流对象，下面哪个选项的代码是错误的?
        try (BufferedWriter a = new BufferedWriter(new FileWriter(""));
//             BufferedReader b = new BufferedReader(new FileOutputStream("")); // 错误的
             GZIPOutputStream c = new GZIPOutputStream(new FileOutputStream(""));
             ObjectInputStream d = new ObjectInputStream(new FileInputStream(""))
        ) {
            System.out.println("2题b是错误的");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 3 下面哪个流类属于面向字符的输入流(D)
        // A BufferedWriter
        // B FileInputStream
        // C ObjectInputStream
        // D InputStreamReader
        // 参考:https://blog.csdn.net/qq_34207892/article/details/79831072

        // 7 下面选项哪个是Spring中接口注入的方式？(A、B、C)
        // A 接口注入
        // B 构造子注入
        // C 设值注入
        // D 指针注入
        // E 命名空间注入

        // 8 下面关于spring描述错误的是(C)
        // A Spring支持可插入的事务管理器，使事务划分更轻松，同时无需处理底层的问题。
        // B Spring事务管理的通用抽象层还包括JTA策略和一个JDBC DataSource。
        // C 与JTA或EJB CMT一样，Spring的事务支持依赖于Java EE环境。
        // D Spring事务语义通过AOP应用于 POJO，通过XML或Java SE 5注释进行配置。

        // 9 下面哪些集合是有序的(A、B、C、D)【多选题】
        // A LinkedList
        // B TreeMap
        // C LinkedHashSet
        // D TreeSet
        // 参考:https://blog.csdn.net/qq_34764487/article/details/75434414

        // 10 下面哪些Map是线程安全的(A、C)【多选题】
        // A Hashtable
        // B TreeMap
        // C ConcurrentHashMap
        // SynchronizedMap(集合工具类下的静态方法)
        // 参考:https://blog.csdn.net/weixin_43374508/article/details/90024426

        // 11 switch语句后的表达式支持的数据类型()【多选题】
        // byte
        // char
        // long
        // int
        // short
        // 答案
        // 基本数据类型:byte  short   char        int
        // 包装数据类型:Byte  Short   Character   Integer
        // 枚举类型:Enum
        // 字符串类型:String(JDK 7+ 开始支持)

        // ？？？什么鬼
        // 12 以下dos命令正确的是()【多选题】
        // dir  显示所有的文件
        // cd / 退回到根目录
        // rd   删除目录
        // cd   进入指定目录

        // 13
        int sum = 0;
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= i; j++) {
                sum++;
            }
        }
        System.out.println("13题：" + sum);

        // 14
        int b = 0;
        while (b < 5) {
            switch (b) {
                case 0:
                case 3:
                    b = b + 2;
                case 1:
                case 2:
                    b = b + 3;
                default:
                    b = b + 5;
            }
        }
        System.out.println("14题：" + b);

        // 15
        int a;
        a = 6;
        System.out.println("第15题：");
        System.out.print(a);
        System.out.print(a++);
        System.out.print(a);
        System.out.println();

        // 6 只重写了equals()方法
        Map<BasePo, BasePo> testMap = new HashMap<>();
        List<BasePo> testList = new ArrayList<>();
        BasePo basePo = new BasePo(123L, "NAME");
        testMap.put(basePo, basePo);
        testList.add(basePo);
        basePo = new BasePo(123L, "NAME");

        System.out.println("6题：");
        // equals,hasCode！！！
        System.out.println("嗯哼" + testMap.containsKey(basePo));    // false    // 因为basePo指向了另一个对象，其对象地址的hashCode改变了 所以查不到这个对象
        System.out.println(testMap.containsValue(basePo));          // true
        System.out.println(testList.contains(basePo));              // true

    }

}
