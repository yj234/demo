package com.example.demouse;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.demo.common.FastClient;
import com.example.demouse.entity.Users;
import com.example.demouse.service.UsersService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest("DemouseApplication.class")
class DemouseApplicationTests {


    // 引入fastClient,自动会找并去读取fast.properties前缀fast的值赋给fastClent类
    @Autowired
    private FastClient fastClient;

    @Autowired
    private UsersService usersService;

    @Autowired
    private DataSource dataSource;

    @Test
    public void contextLoads() {
   /*    System.out.println(fastClient);
       Users users = new Users();
       users.setAge(26);
       users.setName("yml");
       usersService.insert(users);
       //class com.zaxxer.hikari.HikariDataSource*/
       System.out.println(dataSource.getClass());
       if (dataSource instanceof DruidDataSource){
           System.out.println(((DruidDataSource) dataSource).getUrl());
       }
    }

}
