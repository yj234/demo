package com.review;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 *  测试类，解耦配置
 */

@Configuration
@MapperScan("com.review.demo.mapper")
public class ApplicationConfig {
    public ApplicationConfig() {
        //todo 红色：未加入版权控制  绿色：加入版控制未提交 蓝色：提交有改动 白色：无改动
        System.out.println("ApplicationConfig is running...");
    }
}
