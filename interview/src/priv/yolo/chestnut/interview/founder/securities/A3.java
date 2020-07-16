package priv.yolo.chestnut.interview.founder.securities;

/**
 * 3. 写程序判断正整数n是否为回文数。
 * 回文数定义，设n是一任意自然数。若n的各位数字反向排列所得自然数n1与n相等，则称n为一回文数，如 1，11，121，1221，都是回文数。
 */
public class A3 {

    public static void main(String[] args) {
        int x = 120;
        System.out.println(isPalindrome_1(x));
        System.out.println(isPalindrome_2(x));
    }

    // 时间复杂度O(n) 空间复杂度O(n)
    private static boolean isPalindrome_1(int x) {
        if (x < 0) {        // 排除小于0的数，负数肯定不是回文数
            return false;
        }

        String s = String.valueOf(x);
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) != s.charAt(length - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    // 时间复杂度O(1) 空间复杂度O(1)
    private static boolean isPalindrome_2(int x) {
        if (x < 0) {        // 排除小于0的数，负数肯定不是回文数
            return false;
        }

        int temp = x;
        // 数字翻转后可能会超过整形的范围
        long y = 0;
        while (x != 0) {    // 翻转
            y = y * 10 + x % 10;
            x /= 10;
        }

        return temp == y;
    }

}
