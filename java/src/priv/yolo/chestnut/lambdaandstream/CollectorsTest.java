package priv.yolo.chestnut.lambdaandstream;

import priv.yolo.chestnut.lambdaandstream.common.OutstandingClass;
import priv.yolo.chestnut.lambdaandstream.common.SpecialityEnum;
import priv.yolo.chestnut.lambdaandstream.common.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsTest {

    public static void main(String[] args) {
        List<Student> students1 = Arrays.asList(
                new Student("黄1", 16, 160, Arrays.asList(SpecialityEnum.DANCE, SpecialityEnum.RUNNING)),
                new Student("黄2", 17, 154, Arrays.asList(SpecialityEnum.SING, SpecialityEnum.SWIMMING)),
                new Student("黄3", 18, 170, Arrays.asList(SpecialityEnum.SWIMMING, SpecialityEnum.RUNNING)),
                new Student("黄4", 19, 169, Arrays.asList(SpecialityEnum.SWIMMING, SpecialityEnum.DANCE))
        );
        OutstandingClass class1 = new OutstandingClass("1班", students1);

        List<Student> students2 = new ArrayList<>(students1);
        students2.remove(0);
        OutstandingClass class2 = new OutstandingClass("2班", students2);

        // Collectors.maxBy()演示
        // 打印人数多的班级
        Optional<OutstandingClass> biggestClass = Stream.of(class1, class2).max(Comparator.comparing(c -> c.getStudents().size()));
        biggestClass.ifPresent(System.out::println);

        // Collectors.averagingDouble()演示
        // 计算1班的平均年龄
        Double averagingAge = students1.stream().collect(Collectors.averagingInt(Student::getAge));
        System.out.println(averagingAge);

        // Collectors.partitioningBy()演示
        // 将1班按照是否会跳舞进行区分
        Map<Boolean, List<Student>> isDanceResult = students1.stream().collect(Collectors.partitioningBy(student -> student.getSpecialities().contains(SpecialityEnum.DANCE)));
        System.out.println(isDanceResult.get(Boolean.TRUE));
        System.out.println(isDanceResult.get(Boolean.FALSE));

        // Collectors.groupingBy()演示
        // 将1班根据学生第一个爱好进行分组
        Map<SpecialityEnum, List<Student>> groupResult = students1.stream().collect(Collectors.groupingBy(student -> student.getSpecialities().get(0)));
        Stream.of(groupResult).forEach(System.out::println);

        // Collectors.joining()演示
        // 打印1班学生姓名
        String names = students1.stream().map(Student::getName).collect(Collectors.joining(",", "(", ")"));
        System.out.println(names);

    }

}
