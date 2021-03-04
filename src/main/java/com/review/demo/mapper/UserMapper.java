package com.review.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.review.demo.model.User;
import com.review.demo.model.UserDept;
import com.review.demo.model.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    List<User> selectByContent1(@Param("createTime") String createTime);

    int insertUserDept(List<UserDept> list);

    int insertUserRole(List<UserRole> list);

}