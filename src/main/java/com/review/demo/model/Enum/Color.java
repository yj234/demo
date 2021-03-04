package com.review.demo.model.Enum;

import com.review.demo.model.User;

import java.util.EnumMap;
import java.util.EnumSet;

public enum Color {
    RED(1,"红色"),BLUE(2,"蓝色"),GREEN(3,"绿色"),YELLOW(4,"黄色");

    private int index;
    private String value;

    Color(int index, String value) {
        this.index = index;
        this.value = value;
    }


    public static String getColor(Integer type){
        if (type == null){
            return Color.BLUE.value;
        }
        for (Color c : Color.values()) {
            if (c.index == type){
                return c.value;
            }
        }
        return Color.BLUE.value;
    }

    public static void main(String[] args) {
        System.out.println(Color.getColor(3));
        //todo EnumMap
        EnumMap map = new EnumMap(Color.class);//EnumMap中的 key是enum类型，而value则可以是任意类型
        map.put(Color.BLUE, new User());
        map.put(Color.GREEN, "work");
        System.out.println(map.get(Color.BLUE));
        //todo EnumSet
        EnumSet setNone = EnumSet.noneOf(Color.class);//创建一个空队列
        EnumSet setAll = EnumSet.allOf(Color.class);//创建一个空队列
        EnumSet setRang = EnumSet.range(Color.RED,Color.GREEN);//创建范围内队列
        EnumSet setCom = EnumSet.complementOf(setRang); // 创建队列的补集
        EnumSet setCopy = EnumSet.copyOf(setCom);//可以复制集合，EnumSet
        System.out.println(setAll);
        System.out.println(setNone);
        System.out.println(setRang);
        System.out.println(setCom);
    }
}
