package priv.yolo.chestnut.interview.scienjoy._20190809;

/**
 * Given an array of integers, our task is to write a program that
 * efficiently finds the second largest element present in the array.
 * 给定一个整数数组，我们的任务是编写一个程序，有效的查找数组中存在的第二大元素.
 */
public class A1 {

    public static void main(String[] args) {
        int[] test = {3, 3, 3, 7, 9, 122344, 4656, 34, 34, 4656, 5, 6, 7, 8, 9, 343, 57765, 23, 12321};
        int len = test.length - 1;
        quickSort(test, 0, len);
        for (int i : test) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("第二大元素为：" + test[len - 1]);
    }

    private static void quickSort(int[] arr, int low, int high) {
        int i = low;
        int j = high;

        int pivot = arr[low];
        while (i < j) {
            while (i < j && arr[j] > pivot) {
                j--;
            }

            while (i < j && arr[i] < pivot) {
                i++;
            }

            if (i < j && arr[i] == arr[j]) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        if (i - 1 > low) {
            quickSort(arr, low, i - 1);
        }

        if (j + 1 < high) {
            quickSort(arr, j + 1, high);
        }

    }

}
