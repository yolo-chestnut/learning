package priv.yolo.chestnut.interview.boss._20181118;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 写出一个函数，输入字符串和类型（类型包括：字母，空格，数字，其它字符），
 * 要求返回该字符串含有此类型字符的个数。
 */
public class A1 {

    public static void main(String[] args) {
        String s = "abc1234!@#  ";
        // 字母-1 空格-2 数字-3 其它字符-4
        System.out.print(m1(s, 1) + " ");
        System.out.print(m1(s, 2) + " ");
        System.out.print(m1(s, 3) + " ");
        System.out.print(m1(s, 4) + " ");
        System.out.println();
        System.out.print(m2(s, 1) + " ");
        System.out.print(m2(s, 2) + " ");
        System.out.print(m2(s, 3) + " ");
        System.out.print(m2(s, 4) + " ");
        System.out.println();
        System.out.print(m3(s, 1) + " ");
        System.out.print(m3(s, 2) + " ");
        System.out.print(m3(s, 3) + " ");
        System.out.print(m3(s, 4) + " ");
        System.out.println();
    }

    private static int result(int letterNum, int spaceNum, int digitNum, int otherNum, int type) {
        int result = 0;
        switch (type) {
            case 1:
                result = letterNum;
                break;
            case 2:
                result = spaceNum;
                break;
            case 3:
                result = digitNum;
                break;
            case 4:
                result = otherNum;
                break;
        }
        return result;
    }

    // 解法1：根据字符（本质为ASCII码）进行判断
    private static int m1(String s, int type) {
        int letterNum = 0;  // 含有字母的个数
        int spaceNum = 0;   // 含有空格的个数
        int digitNum = 0;   // 含有数字的个数
        int otherNum = 0;   // 含有其它字符的个数

        char[] chars = s.toCharArray();
        for (char c : chars) {
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                letterNum++;
            } else if (c == ' ') {
                spaceNum++;
            } else if (c >= '0' && c <= '9') {
                digitNum++;
            } else {
                otherNum++;
            }
        }

        return result(letterNum, spaceNum, digitNum, otherNum, type);
    }

    // 解法2：根据Character包装类提供的方法进行判断
    private static int m2(String s, int type) {
        int letterNum = 0;  // 含有字母的个数
        int spaceNum = 0;   // 含有空格的个数
        int digitNum = 0;   // 含有数字的个数
        int otherNum = 0;   // 含有其它字符的个数

        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (Character.isLetter(c)) {
                letterNum++;
            } else if (Character.isSpaceChar(c)) {
                spaceNum++;
            } else if (Character.isDigit(c)) {
                digitNum++;
            } else {
                otherNum++;
            }
        }

        return result(letterNum, spaceNum, digitNum, otherNum, type);
    }

    // 解法3：根据正则表达式进行判断
    private static int m3(String str, int type) {
        int letterNum = 0;  // 含有字母的个数
        int spaceNum = 0;   // 含有空格的个数
        int digitNum = 0;   // 含有数字的个数
        int otherNum;       // 含有其它字符的个数

        Pattern l = Pattern.compile("[a-zA-Z]");
        Pattern s = Pattern.compile("[\\s]");
        Pattern d = Pattern.compile("[0-9]");

        Matcher ml = l.matcher(str);
        Matcher ms = s.matcher(str);
        Matcher md = d.matcher(str);

        while (ml.find()) {
            letterNum++;
        }
        while (ms.find()) {
            spaceNum++;
        }
        while (md.find()) {
            digitNum++;
        }
        otherNum = str.length() - letterNum - spaceNum - digitNum;

        return result(letterNum, spaceNum, digitNum, otherNum, type);
    }

}
