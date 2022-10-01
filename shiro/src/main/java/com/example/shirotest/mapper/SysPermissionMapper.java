package com.example.shirotest.mapper;

import com.example.shirotest.entity.SysPermission;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@Mapper
public interface SysPermissionMapper {
    public List<SysPermission> selectPermissionByRoleId(int id);
}
