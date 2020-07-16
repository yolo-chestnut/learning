package priv.yolo.chestnut.interview.crcc._20190416;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
//        List<? super Number> fooA = new ArrayList<Integer>();
        List<? extends Number> fooB = new ArrayList<Double>();
        List<? super Integer> fooC = new ArrayList<Number>();
        List<? extends Number> fooD = new ArrayList<Integer>();

        int i = -1;
//        char c = "a";
//        boolean b = null;
        double d = 10.0;
    }

}

class A {
    int i = method();
    static int j = method2();
    int k = 0;

    A() {
        System.out.println(1);
    }

    int method() {
        System.out.println(2);
        return 2;
    }

    static int method2() {
        System.out.println(3);
        return 3;
    }

}

class B extends A {
    int m = method3();
    static int n = method4();
    int t = 0;

    B() {
        System.out.println(4);
    }

    int method3() {
        System.out.println(5);
        return 5;
    }

    static int method4() {
        System.out.println(6);
        return 6;
    }

    public static void main(String[] args) {
        System.out.println(7);
        A a = new B();
    }

}
