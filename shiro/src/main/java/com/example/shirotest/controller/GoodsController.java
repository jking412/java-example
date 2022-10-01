package com.example.shirotest.controller;

import com.example.shirotest.mapper.GoodsMapper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GoodsController {

    @Autowired
    private GoodsMapper goodsMapper;

    @GetMapping(value = "/goods")
    @RequiresPermissions("goods:query")
    public Object selectAllGoods(){
        return goodsMapper.selectAllGoods();
    }

    @GetMapping(value = "/goods/{id}")
    @RequiresPermissions("goods:query")
    public Object selectGoodsById(int id){
        return goodsMapper.selectGoods(id);
    }

    @PostMapping(value = "/goods/add")
    @RequiresRoles("admin")
    public Object addGoods(@RequestBody Map<String,Object> map){
        return goodsMapper.addGoods(map.get("name").toString(),map.get("price").toString());
    }

    @GetMapping(value = "/goods/delete/{id}")
    @RequiresPermissions("goods:delete")
    public Object deleteGoods(int id){
        return goodsMapper.deleteGoods(id);
    }

    @PostMapping(value = "/goods/update")
    @RequiresPermissions("goods:update")
    public Object updateGoods(int id, String name, String price){
        return goodsMapper.updateGoods(id, name, price);
    }



}
