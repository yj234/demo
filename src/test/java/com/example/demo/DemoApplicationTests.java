package com.example.demo;

import com.example.demo.common.FastClient;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest("DemoApplication.class")
public class DemoApplicationTests {

    @Autowired
    FastClient fastClient;

    @Test
    void contextLoads() {
        System.out.println(fastClient);
    }

}
