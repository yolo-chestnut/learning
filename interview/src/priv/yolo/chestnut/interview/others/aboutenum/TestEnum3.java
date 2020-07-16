package priv.yolo.chestnut.interview.others.aboutenum;

// 构造器默认是 private，无法更改
public enum TestEnum3 {
    THREE("测试");

    private String des;

    // 编译后默认是 private
    TestEnum3(String des) {
        this.des = des;
    }

    public String getDes() {
        return des;
    }

}
