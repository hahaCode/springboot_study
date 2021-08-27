package com.fan.shiroStudy.mapper;

import com.fan.shiroStudy.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    public User findUserByName(String username);

}
