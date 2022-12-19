package com.example.demouse.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * Spring AOP面向切面编程，可以用来配置事务、做日志、权限验证、在用户请求时做一些处理等等。用@Aspect做一个切面，就可以直接实现。
 * 参考博客：https://blog.csdn.net/u012326462/article/details/82529835?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1.no_search_link&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1.no_search_link
 */
//@Component
@Aspect
public class LogAop {

    private static final Logger logger = LoggerFactory.getLogger(LogAop.class);
    /**
        execution(方法修饰符 返回类型 方法全限定名(参数))         主要用来匹配整个方法签名和返回值的
    */
    private static final String POINT_CUT = "execution(public * com.example.demouse.controller.*.*(..))";

    // @Pointcut切点注解，想在一个空方法上面，一会儿在Advice通知中，直接调用这个空方法就行了，也可以把切点表达式卸载Advice通知中的，单独定义出来主要是为了好管理
    @Pointcut(POINT_CUT)
    public void pointCut(){};

    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint){
        System.out.println("before");
        Arrays.stream(joinPoint.getArgs()).forEach(System.out::println);
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        logger.info("ip: "+request.getRemoteHost()+" uri: "+request.getRequestURI());
    }

    @Around(value = POINT_CUT)
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around start:" + LocalDateTime.now());
        //String[] args = {"joinPoint.proceed(args)","fdd"};
        Object obj = joinPoint.proceed();
        System.out.println("around end:" + LocalDateTime.now());
        return obj;
    }

    @AfterReturning(value = POINT_CUT,returning = "result")
    public void afterReturning(String result){
        System.out.println("afterReturning,方法返回值："+result);
    }
}
