package com.example.demouse.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Student {
    private Integer age;
    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Student(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Student(Integer age) {
        this.age = age;
        this.name = "tom";
    }

    public Student() {
        this.name = "tom";
        this.age = 18;
    }

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        //list.add(new Student(56,"15"));
         for (int i = 0; i <5 ; i++) {
            list.add(new Student(10+i));
        }
      /* Map<String, Object> map = list.stream().collect(Collectors.toMap(Student::getName, Student::getYourAge,(name,age)->{
            List nameList = new ArrayList<>();
            nameList.add(name);
            return list.stream().distinct().collect(Collectors.toList());
        }));
        Map<String, Object> map = list.stream().collect(Collectors.toMap(Student::getName, Student::getYourAge));
        map.entrySet().forEach(e-> System.out.println(e.getKey()+","+e.getValue()));*/
        Optional<Student> optional = list.stream().filter(e -> e.getName().endsWith("m")).findAny();
        System.out.println(optional);
    }

    public static double getYourAge(Student student){
        return  student.getAge();
    }



}
