package com.example.demouse;

import com.example.demo.config.MyConfig;
import com.example.demouse.entity.Users;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;

@Import(MyConfig.class)
@SpringBootApplication
@MapperScan("com.example.demouse.mapper")
//@ServletComponentScan
public class DemouseApplication {
    private static int count;
    public static void main(String[] args) {
        SpringApplication.run(DemouseApplication.class, args);
        // System.out.println("最大内存" + Runtime.getRuntime().maxMemory() / (1024 * 1024));
       //  System.out.println("总共内存" + Runtime.getRuntime().totalMemory() / (1024 * 1024));
        ArrayList<Users> list = new ArrayList<>();
        try {
            while (true) {
                list.add(new Users());
                count++;
                System.out.println(count);
            }
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
    }

}
