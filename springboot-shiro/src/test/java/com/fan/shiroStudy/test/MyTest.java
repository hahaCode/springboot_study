package com.fan.shiroStudy.test;

import com.fan.shiroStudy.domain.User;
import com.fan.shiroStudy.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyTest {

    @Autowired
    private UserService userService;

    @Test
    public void test1() {
        User user = userService.findUserByName("Bob");
        System.out.println(user);
    }
}
