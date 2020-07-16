package priv.yolo.chestnut.interview.others;

// https://www.cnblogs.com/justcooooode/p/7603381.html
// https://www.cnblogs.com/aspirant/p/9193112.html
// https://blog.csdn.net/u013366617/article/details/83618361
public class StringIntern {

    public static void main(String[] args) {
        // 字符串常量池中创建"abc"常量
        String str0 = "abc";

        // 字符串常量池中创建"def"常量、堆中创建对象
        String str1 = new String("def");
        str1.intern();

        // 美团
        // https://tech.meituan.com/2014/03/06/in-depth-understanding-string-intern.html
        String s0 = new String("a");
        s0.intern();
        String s1 = "a";
        System.out.println(s0 == s1);   // false

        // 编译期无法确定，编译器不会优化，字符串常量池不存在"abcd"字符串
        String s2 = new String("ab") + new String("cd");
        // 字符串常量池存储堆中"abcd"的引用
        s2.intern();
        String s3 = "abcd";
        System.out.println(s2 == s3);   // true

    }

}
