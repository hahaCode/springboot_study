package com.fan.springboot.redis.mapper;

import com.fan.springboot.redis.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserXmlMapper {

    public List<User> findAll();
}
