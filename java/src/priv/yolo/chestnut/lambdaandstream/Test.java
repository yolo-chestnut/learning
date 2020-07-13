package priv.yolo.chestnut.lambdaandstream;

import priv.yolo.chestnut.lambdaandstream.common.Student;

import java.util.function.*;

public class Test {

    public static void main(String[] args) {
        Student student = new Student("张三", 18, 177);

        // 断言、判断
        Predicate<Integer> predicate = x -> x > 160;
        System.out.println("身高是否有160 ？：" + predicate.test(student.getStature()));

        // 消费者
        Consumer<String> consumer = System.out::println;
        consumer.accept("测试！测试！");

        // 函数
        Function<Student, String> function = Student::getName;
        // 输入一个学生（Student），输出学生名字（String）
        String studentName = function.apply(student);
        System.out.println(studentName);

        // 供应商（生产者，工厂）
        Supplier<Student> supplier = () -> new Student("张三", 30, 180);
//        System.out.println(supplier.get() == supplier.get());
        System.out.println(supplier.get());

        // 一元运算符
        UnaryOperator<Integer> unaryOperator = x -> ++x;
        System.out.println(unaryOperator.apply(1));

        // 二元操作符
        BinaryOperator<Integer> binaryOperator = (x, y) -> x * y + y;
        System.out.println(binaryOperator.apply(3, 5));

        // 自定义测试
        MyTestFunctionInterface<Student> test = stu -> "你好！" + stu.getName();
        String str = test.sayHello(student);
        System.out.println(str);

    }

}

interface MyTestFunctionInterface<T> {

    String sayHello(T t);

}
