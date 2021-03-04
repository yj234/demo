package com.review.demo.action;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.review.demo.common.Resp;
import com.review.demo.model.User;
import com.review.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class UserAction {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    public Resp add(@RequestBody User user) {
        Boolean falg = userService.save(user);
        Resp re = null;
        if (falg) {
            re = Resp.SUCCESS.setReslut(falg);
        } else {
            re = Resp.Fail.setReslut("新增失败");
        }
        return re;
    }

    @PostMapping("/insert")
    public int addByMap(@RequestBody Map<String, Object> map) {
        return userService.addByMap(map);
    }

    @RequestMapping(value = "/selAll", method = {RequestMethod.GET})
    public Resp selAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userService.list(new QueryWrapper<>());
        Map<String, Object> map = new HashMap<>();
        map.put("total", users.size());
        map.put("records", users);
        return Resp.SUCCESS.setReslut(map);
    }

    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public Resp login(String userName, String passWord) {
        Resp re;
        if (userName == null || passWord == null) {
            throw new RuntimeException("账号密码不能为空");
        }
        User user = new User();
        user.setUserName(userName);
        user.setPassWord(passWord);
        User target = userService.getOne(new QueryWrapper<>(user));
        if (target != null) {
            re = Resp.SUCCESS.setReslut("登录成功");
        } else {
            re = Resp.Fail.setReslut("账号名或密码错误");
        }
        return re;
    }

}