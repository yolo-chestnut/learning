package priv.yolo.chestnut.lambdaandstream;

import priv.yolo.chestnut.lambdaandstream.common.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestCase {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("张三", 30, 181),
                new Student("李四", 22, 183),
                new Student("王五", 21, 184),
                new Student("赵六", 33, 189)
        );

        List<Integer> list = Stream.of(1, 3, 5, 7, 9).collect(Collectors.toList());
        System.out.println(list);

        // PS：每个stream只能用1次
        // filter用法演示
        List<Student> students185 = students.stream().filter(student -> student.getStature() > 185).collect(Collectors.toList());
        System.out.println("身高大于185：" + students185);

        // map用法演示
        List<String> names = students.stream().map(Student::getName).collect(Collectors.toList());
        System.out.println(names);

        // flatMap用法演示，请注意与map区别，参考链接：https://www.cnblogs.com/diegodu/p/8794857.html
        List<Student> newStudents = Arrays.asList(
                new Student("黄三", 17, 174),
                new Student("吕四", 18, 177)
        );
        List<List<Student>> lists = new ArrayList<>();
        lists.add(newStudents);
        lists.add(students);
        List<Student> allStudents = lists.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(allStudents);

        // max用法演示
        Optional<Student> maxAgeStudent = students.stream().max(Comparator.comparing(Student::getAge));
        maxAgeStudent.ifPresent(System.out::println);

        // min用法演示
        Optional<Student> minAgeStudent = students.stream().min(Comparator.comparing(Student::getAge));
        minAgeStudent.ifPresent(System.out::println);

        // count用法演示
        long count = students.stream().filter(student -> student.getStature() < 185).count();
        System.out.println("身高小于185的人数：" + count);

        // reduce用法演示，identity 累加器初始值
        Integer result = Stream.of(1, 3, 5, 7, 9).reduce(0, Integer::sum);
        System.out.println(result);

    }

}
