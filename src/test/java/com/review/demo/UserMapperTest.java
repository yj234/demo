package com.review.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.review.demo.mapper.UserMapper;
import com.review.demo.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {


    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList(){
        System.out.println(("----- selectAll method test ------"));
        Page<Object> page = PageHelper.startPage(1, 3);
        List<User> userList = userMapper.selectList(new QueryWrapper<>());
        //Assert.assertEquals(5, userList.size());
        //userList.forEach(System.out::println);
        PageInfo pageInfo1 = new PageInfo(userList);
        System.out.println(pageInfo1);
    }

    @Test
    public void testSelectByContent(){
       //List<User> result = userMapper.selectList(new QueryWrapper<User>().lt("create_time","2021-02-03"));
        String time = "2021-02-03 11:03:40";
        List<User> result = userMapper.selectByContent1(time);
        result.forEach(System.out::println);
    }


}

