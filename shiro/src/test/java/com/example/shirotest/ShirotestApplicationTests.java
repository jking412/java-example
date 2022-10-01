package com.example.shirotest;

import com.example.shirotest.mapper.GoodsMapper;
import com.example.shirotest.mapper.SysPermissionMapper;
import com.example.shirotest.mapper.UserInfoMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Map;

@SpringBootTest
class ShirotestApplicationTests {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Test
    void contextLoads() {

    }

}
