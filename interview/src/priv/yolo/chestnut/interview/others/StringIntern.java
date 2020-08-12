package priv.yolo.chestnut.interview.others;

// https://www.cnblogs.com/justcooooode/p/7603381.html
// https://www.cnblogs.com/aspirant/p/9193112.html
// https://blog.csdn.net/u013366617/article/details/83618361
public class StringIntern {

    /*
    关于String.intern的理解：
    1.jdk1.7及之后，字符串常量池（C++实现的一个HashTable类）由方法区移动至堆内存。
    2.运行时常量池在方法区，主要包含class文件中常量池部分，同时也允许运行时候新增常量。

    a.编译（.java文件->.class文件）：
    源文件编译成字节码的过程中，会有一些优化，例如：String s = "a" + "b"; 会被优化成：String s = "ab";
    b.类加载：
    class文件中常量池部分会构成运行时常量池，运行时常量池中String类型会交由字符串常量池处理，以此类推（后半句是我猜的）。

    intern方法：
    会从字符串常量池查找有无与主调者(例如，"abc".intern()，主调用者就是"abc")相等的字符串：
    a. 若字符串常量池中没有，则将主调者的引用添加至字符串常量池，然后返回该引用
    b. 若字符串常量池中存在，则直接返回字符串的引用或者上种情况添加的引用

    new String(String original); 新的String对象的char[]会引用original的char[]
    */

    public static void main(String[] args) {
        // 字符串常量池中创建"abc"常量
        String str0 = "abc";

        // 字符串常量池中创建"def"常量、堆中创建对象
        String str1 = new String("def");
        str1.intern();

        // 美团
        // https://tech.meituan.com/2014/03/06/in-depth-understanding-string-intern.html
        /*
        String s0 = new String("a");在堆中新建String对象（其char[]引用字符串常量池中"a"，jvm保证"a"会在new之前在常量池中被创建），将新建对象引用付给s0
        s0.intern();方法 会在字符串常量池中查找s0(及s0所代表的的"a")，此时字符串常量池中存在"a"，所以讲次引用返回，但是此处没有接受返回值，所以没什么更改。
        String s1 = "a";jvm会在字符串常量池中查找是否存在，若存在直接返回，不存在直接在常量池中新建，此时常量池中存在"a"，所以s1直接指向字符串常量池中的"a"。
        System.out.println(s0 == s1);结果为false，因为s0指向堆内存生成的对象，s1指向字符串常量池中的对象。
         */
        String s0 = new String("a");
        s0.intern();
        String s1 = "a";
        System.out.println(s0 == s1);   // false

        /*
        在执行s2.intern();的时候，字符串常量池中不存在"abcd"，所以字符串常量池会存储s2引用。
        当执行String s3 = "abcd";会在字符串常量池中查找"abcd"，正好s2引用即为"abcd"，所以返回s2引用，所以s2与s3相等
        */
        String s2 = new String("ab") + new String("cd");
        s2.intern();
        String s3 = "abcd";
        System.out.println(s2 == s3);   // true

    }

}
