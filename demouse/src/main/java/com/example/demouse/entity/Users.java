package com.example.demouse.entity;

public class Users {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", age=").append(age);
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
    /* String s= "fw";
     Object o= s;
     sayhello(o);
     sayhello(s);*/
        mystery(1234);
    }
    public static int split(int number){
        if (number > 1){
            if (number % 2 != 0){
                System.out.println(split((number + 1) / 2));
            }
            System.out.println(split(number/2));
        }
        return number;
    }
    public static void sayhello(String o){
        System.out.println("hello"+o);
    }
    public static void sayhello(Object o){
        System.out.println("sayhello(Object o)"+o);
    }


    public static void mystery(int x){
        System.out.println(x % 10);
        if ((x / 10) != 0){
            mystery(x / 10);
        }
        System.out.println(x % 10);
    }

}