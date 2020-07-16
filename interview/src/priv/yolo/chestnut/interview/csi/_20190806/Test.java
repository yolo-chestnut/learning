package priv.yolo.chestnut.interview.csi._20190806;

/**
 * 一、填空题
 * 12.阅读下面代码，写出输出结果是？
 * 结果：beijing and z软国际
 */
public class Test {

    String str = new String("beijing");

    char[] ch = {'中', '软', '国', '际'};

    public void change(String str, char[] ch) {
        str = "chengdu";
        ch[0] = 'z';
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.change(test.str, test.ch);
        System.out.print(test.str + " and ");
        System.out.print(test.ch);
        System.out.println();
    }

}
