package domain;

import anno.FieldMeta;

public class Man {

    @FieldMeta(description = "姓名")
    private String name;

    @FieldMeta(description = "年龄")
    private Integer age;


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

    public Man(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Man() {
    }

    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}