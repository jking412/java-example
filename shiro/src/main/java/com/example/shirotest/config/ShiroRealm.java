package com.example.shirotest.config;

import com.example.shirotest.entity.SysPermission;
import com.example.shirotest.entity.SysRole;
import com.example.shirotest.entity.UserInfo;
import com.example.shirotest.mapper.SysPermissionMapper;
import com.example.shirotest.mapper.UserInfoMapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        UserInfo userInfo = (UserInfo) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for(SysRole role : userInfo.getRoles()){
            simpleAuthorizationInfo.addRole(role.getRole());
            List<SysPermission> sysPermissions = sysPermissionMapper.selectPermissionByRoleId(role.getId());
            for(SysPermission sysPermission : sysPermissions){
                simpleAuthorizationInfo.addStringPermission(sysPermission.getName());
            }
        }
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String)authenticationToken.getPrincipal();
        UserInfo userInfo = userInfoMapper.findByUsername(username);
        if(username == null){
            return null;
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userInfo,
                userInfo.getPassword(),
                ByteSource.Util.bytes(userInfo.getSalt()),
                this.getName());
        return simpleAuthenticationInfo;
    }
}
