package priv.yolo.chestnut.interview.founder.securities;

/**
 * 1. 写程序实现单例模式
 * 参考链接1：https://www.jianshu.com/p/d35f244f3770 感觉有问题！
 * 参考链接2：https://www.cnblogs.com/hechangshou/p/8251230.html 这个比较有参考价值
 */

/**
 * 枚举单例 线程安全 反序列化安全
 * 枚举在安卓环境中比较消耗内存
 */
public enum A1_2 {
    INSTANCE
}

/**
 * 静态内部类 线程安全
 */