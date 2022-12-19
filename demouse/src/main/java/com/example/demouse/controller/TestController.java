package com.example.demouse.controller;

import com.example.demouse.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String goIndex(ModelMap map) {
        map.put("title", "welcome to index");
        map.put("student", new Student());
        return "index";
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showIndex(ModelMap map) {
        List<Student> list = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            list.add(new Student(i, "tom"));
        }
        map.put("list", list);
        map.put("date", new Date());
        return "index2";
    }

    @GetMapping("/say/{name}")
    @ResponseBody
    public String say(@PathVariable("name") String name, @ModelAttribute("words") String words) {
        //System.out.println(new Date());
        return "区别 server.servlet.context-path 跟 spring.application.name=demouse" + "<" + name + ">";
    }
}
