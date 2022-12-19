package com.example.demouse.filter;


import javax.servlet.*;
import java.io.IOException;

// 第一种写法 @WebFilter(filterName = "MyFilter" ,value = "/*")
public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("myFilter is start..");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
