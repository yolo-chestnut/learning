package priv.yolo.chestnut.interview.csi._20190806;

/**
 * 三、编程题
 */
public class A {

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        sum(array);

        sortByString();
    }

    // 1. 求一个3*3矩阵对角线元素之和。
    private static void sum(int[][] array) {
        int sum0 = 0;
        int sum1 = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j) {
                    sum0 += array[i][j];
                }
                if (i == array.length - 1 - j) {
                    sum1 += array[i][j];
                }
            }
        }
        System.out.println("sum0 = " + sum0);
        System.out.println("sum1 = " + sum1);
        // 定义一个整型数组：3行4列
        // int a[][] = new int[3][4];
        // 获取行数---3行
        // int lenY = a.length;
        // 获取列数---4列
        // int lenX = a[0].length;
        // 因为二维数组可以理解为是一维数组，只不过它的元素是一维数组
    }

    // 2. 用1、2、2、3、4、5这六个数字，用java写一个main函数，打印出所有不同的排列，如：512234、412345等，要求：'4'不能在第三位，'3'与'5'不能相连。
    private static void sortByString() {
        int count = 0;
        for (int i = 122345; i <= 543221; i++) {
            String s = String.valueOf(i);
            if (validate(s)) {
                if ((!s.contains("35")) && (!s.contains("53"))
                        && (s.charAt(2) != '4')) {
                    System.out.println(s);
                    count++;
                }
            }
        }
        System.out.println("总数量为：" + count);
    }

    private static boolean validate(String s) {
        int[] temp = {0, 0, 0, 0, 0};
        for (int i = 0; i < 6; i++) {
            if (s.charAt(i) == '1') temp[0]++;
            if (s.charAt(i) == '2') temp[1]++;
            if (s.charAt(i) == '3') temp[2]++;
            if (s.charAt(i) == '4') temp[3]++;
            if (s.charAt(i) == '5') temp[4]++;
        }

        return temp[0] == 1 && temp[1] == 2 && temp[2] == 1 && temp[3] == 1 && temp[4] == 1;
    }

}
