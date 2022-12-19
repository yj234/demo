package com.example.demouse.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class ExceptionAdvice {

    private static final Logger logger = LoggerFactory.getLogger("TestController.class");

    /**
     * 用处1: 结合注解ExceptionHandler，捕获参数类型异常，给出统一回复
     */
    @ExceptionHandler
    @ResponseBody
    public ModelAndView exceptionHander(Exception exception) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", exception.getMessage());
        modelAndView.setViewName("/error");
        return modelAndView;
    }

    /**
     * 用处2: 结合注解ModelAttribute，数据绑定
     */
    @ModelAttribute
    public Model preData(Model model) {
        model.addAttribute("words", "hello world");
        return model;
    }

    /**
     * 用处3: 结合注解InitBinder，数据预处理，预先处理时间格式，数据转化等
     */
    @InitBinder
    public void globalInitBinder(WebDataBinder binder) {
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }

    /**
     * 用处3: 结合注解InitBinder，数据预处理，一个controller中两个参数拥有一样的属性，无法区分，这时候通过前缀即可解决
     * @ModelAttribute("b") Book book, @ModelAttribute("a") Author author
     */
    @InitBinder
    public void a(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("a");
    }

    @InitBinder
    public void b(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("b");
    }
}
