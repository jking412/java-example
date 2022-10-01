package com.example.shirotest.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class SysRole {
    private Integer id;
    private String role;
    private String description;

    public SysRole(String role, String description) {
        this.role = role;
        this.description = description;
    }
}
