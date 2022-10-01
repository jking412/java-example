package com.example.shirotest.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Goods {
    private int id;
    private String name;
    private String price;

    public Goods(String name, String price) {
        this.name = name;
        this.price = price;
    }
}
