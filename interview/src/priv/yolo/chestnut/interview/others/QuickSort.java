package priv.yolo.chestnut.interview.others;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 3, 3, 7, 9, 122344, 4656, 34, 34, 4656, 5, 6, 7, 8, 9, 343, 57765, 23, 12321};
        int len = arr.length - 1;
        arr = quickSort(arr, 0, len);
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    private static int[] quickSort(int[] arr, int low, int high) {
        int i = low, j = high;
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
            arr = quickSort(arr, low, i - 1);
        }
        if (j + 1 < high) {
            arr = quickSort(arr, j + 1, high);
        }

        return arr;
    }

}
