package priv.yolo.chestnut.interview.scienjoy._20190809;

import java.util.ArrayList;

/**
 * Given input as k sorted arrays, generate a single sorted list as output.
 * Eg:
 * Array1: 1 5 8 9 11 ...
 * Array2: 2 12 24 44 ...
 * .
 * .
 * .
 * Arrayk 3 15 79 115 ...
 * Output Array1: 1 2 3 5 8 9 11 12 15 ...
 * PS: 有序数组k路归并问题！！！思路：最小堆、胜者树！！！
 */
public class A2 {

    public static void main(String[] args) {
        ArrayList<int[]> test = new ArrayList<>();
        test.add(new int[]{1, 5, 8, 9, 11, 88, 99});
        test.add(new int[]{2, 12, 24, 44});
        test.add(new int[]{3, 15, 79, 115, 116});

        int[] ints = kPathMerge(test);

        for (int i : ints) {
            System.out.print(i + "  ");
        }
        System.out.println();

    }

    private static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int lpos = 0;
        int rpos = 0;
        for (int i = 0; i < result.length; i++) {
            if (lpos < a.length && rpos < b.length) {
                if (a[lpos] <= b[rpos]) {
                    result[i] = a[lpos++];
                } else {
                    result[i] = b[rpos++];
                }
            } else if (lpos < a.length) {
                result[i] = a[lpos++];
            } else if (rpos < b.length) {
                result[i] = b[rpos++];
            }
        }

        return result;
    }

    private static int[] kPathMerge(ArrayList<int[]> arrs) {
        int k = arrs.size();
        while (k > 1) {
            ArrayList<int[]> temp = new ArrayList<>();
            for (int i = 0; i < k; i += 2) {
                if (i + 1 < k) {
                    int[] current = merge(arrs.get(i), arrs.get(i + 1));
                    temp.add(current);
                } else {
                    temp.add(arrs.get(i));
                }
            }
            arrs.clear();
            arrs.addAll(temp);
            k = arrs.size();
        }

        return arrs.get(0);
    }

}
