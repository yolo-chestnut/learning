package priv.yolo.chestnut.interview.boss._20181118;

/**
 * 写一个函数，将任意long型数字，高效的转换为字符串
 * （禁用toString()，valueOf()，a+""等操作）
 */
public class A2 {

    // 推荐参考toString()实现
    public static void main(String[] args) {
        long l = 1234567890123456789L;
        String s1 = Long.toString(l);
        String s2 = String.valueOf(l);
        String s3 = l + "";

        System.out.println(s1 + " toString()据说效率最高");
        System.out.println(s2);
        System.out.println(s3);
    }

}
