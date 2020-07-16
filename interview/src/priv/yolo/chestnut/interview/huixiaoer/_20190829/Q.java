package priv.yolo.chestnut.interview.huixiaoer._20190829;

public class Q {

    // 一、选择题（有一个或多个答案）
    // 1. 已知类MathUtil，选项中子类实现没有错误的是（A）如下所示：

    // 2. 已知二叉树后序遍历序列是DABFEC，中序遍历序列DFBACE，它的前序遍历序列是（b）
    // a. ACEBFD
    // b. CFDBAE
    // c. DFABEC
    // d. DFECAB

    // 3. 一个栈的输入序列为A B C D E，则下列序列中不可能是栈的输出序列的是（c）
    // a. A E D C B
    // b. B C D A E
    // c. E D A C B
    // d. B C A D E

    // 二、编程题
    // 1. 编写一个程序，将两个有序数据合并为新的有序数据。

    // 2. 实现一种懒汉模式，线程安全的单例类。

    // 3. 设计一个数据结构来存储超大型整数，以及实现加减法运算。

    // 三、问答题
    // 1. 熟悉哪些设计模式，spring中用到了哪些设计模式，举例说明？

    // 2. 设计一个定时任务调度器，实现定时任务调度功能。

    // 3. 设计一个学生成绩系统，管理教师、班级、学生、选课、成绩、画出ER图。

}

class MathUtil {

    protected int mplus(int a, int b) {
        return a + b;
    }

}

class MathUtilEx_A extends MathUtil {

    public int mplus(int a, int b) {
        return a + b + 1;
    }

}

// 方法重写其访问权限不能比父类小！
//class MathUtilEx_B extends MathUtil {
//
//    private int mplus(int a, int b) {
//        return a + b + 1;
//    }
//
//}

// 1.返回值类型不符合
// 2.参数列表变了，不算重写
//class MathUtilEx_C extends MathUtil {
//
//    private int mplus(int a, long b) {
//        return a + b + 1;
//    }
//
//}

// 1.返回值类型不符合
// 2.参数列表变了，不算重写
//class MathUtilEx_D extends MathUtil {
//
//    private short mplus(int a, long b) {
//        return a + b + 1;
//    }
//
//}
