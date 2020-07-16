package priv.yolo.chestnut.interview.others;

public class O2 {

    public static void main(String[] args) {
        Cat cat1 = new Cat("哆唻A梦");
        Cat cat2 = new Cat("哆唻A梦");
        // false
        System.out.println(cat1.equals(cat2));

        String s1 = new String("娃哈哈");
        String s2 = new String("娃哈哈");
        // true
        System.out.println(s1.equals(s2));

        String str1 = "通话";
        String str2 = "重地";
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        // false
        System.out.println(str1.equals(str2));

        long round = Math.round(-1.5);
        // -1
        System.out.println(round);

        // 反转
        StringBuilder sb = new StringBuilder();
        sb.append("abcdefghijklmnopqrstuvwxyz");
        System.out.println(sb.reverse().toString());
    }

}

class Cat {

    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
