package priv.yolo.chestnut.interview.others.aboutenum;

// enum 编译后会追加 static，默认不追加public，如有需要需自行添加
public class TestEnum1 {

    public enum Test1 {
        ONE;

        public void print() {
            System.out.println("测试");
        }
    }

}
