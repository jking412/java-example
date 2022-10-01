package com.example.shirotest.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class SysPermission {
    private int id;
    private String name;
    private String description;
    private String url;

    public SysPermission(String name, String description, String url) {
        this.name = name;
        this.description = description;
        this.url = url;
    }
}
