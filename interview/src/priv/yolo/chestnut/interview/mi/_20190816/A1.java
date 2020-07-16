package priv.yolo.chestnut.interview.mi._20190816;

/**
 * 第1轮
 * 1. 给定指定字符串，去除其中指定字符串（删除所有，包括重组之后），兼顾效率，说明时间复杂度
 * 例：输入"818133813"，需要删除"813"，结果输出""
 */
public class A1 {

    public static void main(String[] args) {
        String oStr = "818133123818133";
        String sStr = "813";
        String result = delSpecificString(oStr, sStr);

        System.out.println(result);
    }

    private static String delSpecificString(String originalStr, String specificStr) {
        if (originalStr.equals("") || !originalStr.contains(specificStr)) {
            return originalStr;
        } else {
            // 去除搜索到的第一个指定字符串，intern()将字符串缓存到字符串常量池，避免重复创建，ps：字符串常量池也有大小，过大亦会影响性能
            originalStr = originalStr.replace(specificStr, "").intern();
            // 递归调用哦
            originalStr = delSpecificString(originalStr, specificStr);
        }

        return originalStr;
    }

}
