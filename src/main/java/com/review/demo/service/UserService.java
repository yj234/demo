package com.review.demo.service;

import com.review.demo.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

public interface UserService extends IService<User>{

    @Override
    int count();

    int addByMap(Map<String, Object> map);
}
