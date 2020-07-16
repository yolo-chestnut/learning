package priv.yolo.chestnut.interview.csi._20190806;

/**
 * 一、填空题
 * 5. 运行下列代码最后输出的结果是？
 * 结果是：1 2 8 9 5
 */
public class MyClass {

    public static void main(String[] args) {
        int[] numberArray = {1, 2, 3, 4, 5};
        int[] temp1 = numberArray;
        int[] temp2 = numberArray;
        int[] temp3 = numberArray;

        temp1[2] = 7;
        temp2[2] = 8;
        temp2[3] = 8;
        temp3[3] = 9;

        for (int i = 0; i < numberArray.length; i++) {
            System.out.print(numberArray[i] + " ");
        }
        System.out.println();
    }

}
