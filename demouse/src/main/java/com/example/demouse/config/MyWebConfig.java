package com.example.demouse.config;

import com.example.demouse.filter.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;


//@Configuration
public class MyWebConfig {

    @Bean
    public FilterRegistrationBean<MyFilter> getFilter(){
        FilterRegistrationBean<MyFilter> frt = new FilterRegistrationBean<>(new MyFilter());
        frt.addUrlPatterns("/*");
        return frt;
    }
}
