package com.example.demouse.controller;

import com.example.demouse.entity.Users;
import com.example.demouse.service.UsersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UsersService usersService;

    @GetMapping(value = "page")
    public PageInfo<Users> pageInfo(int size,int num) {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(num);
        pageInfo.setPageSize(size);

        PageHelper.startPage(num,size);
        List<Users> users = usersService.finAll();
        pageInfo.setTotal(users.size());
        pageInfo.setList(users);
        return pageInfo;
    }
}
