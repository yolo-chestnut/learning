package priv.yolo.chestnut.lambdaandstream.common;

import java.util.List;

public class Student {

    private String name;

    private Integer age;
    // 身材
    private Integer stature;
    // 特长
    private List<SpecialityEnum> specialities;

    public Student() {
    }

    public Student(String name, Integer age, Integer stature) {
        this.name = name;
        this.age = age;
        this.stature = stature;
    }

    public Student(String name, Integer age, Integer stature, List<SpecialityEnum> specialities) {
        this.name = name;
        this.age = age;
        this.stature = stature;
        this.specialities = specialities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getStature() {
        return stature;
    }

    public void setStature(Integer stature) {
        this.stature = stature;
    }

    public List<SpecialityEnum> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(List<SpecialityEnum> specialities) {
        this.specialities = specialities;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", stature=" + stature +
                ", specialities=" + specialities +
                '}';
    }

}
