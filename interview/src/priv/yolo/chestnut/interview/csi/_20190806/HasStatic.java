package priv.yolo.chestnut.interview.csi._20190806;

/**
 * 一、填空题
 * 3. 阅读下段程序，程序输出的结果为？
 * 结果 x=102
 */
public class HasStatic {

    private static int x = 100;

    public static void main(String[] args) {
        HasStatic hs1 = new HasStatic();
        hs1.x++;
        HasStatic hs2 = new HasStatic();
        hs2.x++;
        hs1 = new HasStatic();
        hs1.x++;
        HasStatic.x--;
        System.out.println("x=" + x);
    }

}
