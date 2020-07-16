package priv.yolo.chestnut.interview.founder.securities;

/**
 * 1. 写程序实现单例模式
 * 参考链接1：https://www.jianshu.com/p/d35f244f3770 感觉有问题！
 * 参考链接2：https://www.cnblogs.com/hechangshou/p/8251230.html 这个比较有参考价值
 */

/**
 * 参考链接1提供的写法，感觉有问题，不推荐，留作记录
 */
public class A1_1 {

    // 私有构造函数
    private A1_1() {

    }

    // 定义一个静态枚举类
    // 详见others aboutenum
    static enum SingletonEnum {
        // 创建一个枚举对象，该对象天生为单例
        INSTANCE;

        private A1_1 a;

        private SingletonEnum() {
            a = new A1_1();
        }

        public A1_1 getInstance() {
            return a;
        }
    }

    // 对外暴露一个获取对象的静态方法
    public static A1_1 getInstance() {
        return SingletonEnum.INSTANCE.getInstance();
    }

    public static void main(String[] args) {
        System.out.println(A1_1.getInstance() == A1_1.getInstance());
    }

}
