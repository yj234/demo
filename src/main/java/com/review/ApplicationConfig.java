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
        System.out.println("ApplicationConfig is running...");
    }
}
