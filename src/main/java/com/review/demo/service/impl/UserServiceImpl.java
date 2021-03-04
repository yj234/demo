package com.review.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.review.demo.mapper.UserMapper;
import com.review.demo.model.User;
import com.review.demo.model.UserDept;
import com.review.demo.model.UserRole;
import com.review.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public int count() {
        return userMapper.selectCount(new QueryWrapper<>());
    }

    @Override
    public int addByMap(Map<String, Object> map) {
        //todo 新增用户信息
        int count = 0;
        Object user = map.get("user");
        String userString = JSON.toJSONString(user);
        User userjson = JSON.parseObject(userString, User.class);
        int insert1 = userMapper.insert(userjson);
        if (insert1 > 0) {
            count ++;
        }
        int userId = userjson.getId();
        //todo 新增用户角色，用户部门
        Object userDept = map.get("userDept");
        String userDepts = JSON.toJSONString(userDept);
        List<UserDept> list = JSONArray.parseArray(userDepts, UserDept.class);
        if (list.size() > 0){
            for (UserDept l:list) {
                l.setUserId(userId);
            }
        }
        int insert2 = userMapper.insertUserDept(list);
        if(insert2 > 0 ){
            count ++;
        }
        Object userRole = map.get("userRole");
        String userRoles = JSON.toJSONString(userRole);
        List<UserRole> list1 = JSONArray.parseArray(userRoles, UserRole.class);
        if (list1.size() > 0){
            for (UserRole l:list1) {
                l.setUserId(userId);
            }
        }
        int insert3 = userMapper.insertUserRole(list1);
        if (insert3 > 0){
            count ++;
        }
        return count;
    }
}
