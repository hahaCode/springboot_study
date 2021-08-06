package com.fan.springBootTest;

import com.fan.otherStudy.Application;
import com.fan.otherStudy.service.UserService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * UserService的测试类
 */

@SpringBootTest(classes = Application.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testAdd() {
        userService.add();
    }
}
