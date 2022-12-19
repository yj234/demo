package com.example.demouse.service;

import com.example.demouse.entity.Users;

import java.util.List;

public interface UsersService {

    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    List<Users> finAll();

}
