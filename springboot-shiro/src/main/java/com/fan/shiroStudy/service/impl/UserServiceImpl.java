package com.fan.shiroStudy.service.impl;

import com.fan.shiroStudy.domain.User;
import com.fan.shiroStudy.mapper.UserMapper;
import com.fan.shiroStudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByName(String username) {
        return userMapper.findUserByName(username);
    }
}
