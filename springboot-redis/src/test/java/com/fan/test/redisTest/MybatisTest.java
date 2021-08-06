package com.fan.test.redisTest;

import com.fan.springboot.redis.Application;
import com.fan.springboot.redis.domain.User;
import com.fan.springboot.redis.mapper.UserMapper;
import com.fan.springboot.redis.mapper.UserXmlMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = Application.class)
public class MybatisTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserXmlMapper userXmlMapper;

    @Test
    public void testFindAll() {
        List<User> users = userMapper.findAll();
        System.out.println(users);
    }

    @Test
    public void testXmlFindAll() {
        List<User> users = userXmlMapper.findAll();
        System.out.println(users);
    }

}
