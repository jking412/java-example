package com.example.shirotest.mapper;

import com.example.shirotest.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserInfoMapper {
    public UserInfo findByUsername(String username);
}
