package com.fan.otherStudy.service.impl;

import com.fan.otherStudy.service.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("User add....");
    }
}
