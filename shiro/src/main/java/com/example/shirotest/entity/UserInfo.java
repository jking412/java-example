package com.example.shirotest.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
public class UserInfo {

    private int id;
    private String username;
    private String password;
    private String salt;

    private List<SysRole> roles;

    public UserInfo(String username, String password, String salt) {
        this.username = username;
        this.password = password;
        this.salt = salt;
    }

}
