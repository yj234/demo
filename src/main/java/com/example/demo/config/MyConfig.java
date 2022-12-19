package com.example.demo.config;

import com.example.demo.common.FastClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Configuration
@PropertySource("classpath:fast.properties")
public class MyConfig{

    @Bean
    @ConfigurationProperties(prefix = "fast")
    public FastClient getFastClient(){
        return new FastClient();
    }
}
