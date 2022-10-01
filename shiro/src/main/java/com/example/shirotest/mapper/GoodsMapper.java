package com.example.shirotest.mapper;


import com.example.shirotest.entity.Goods;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface GoodsMapper {

    public int addGoods(String name, String price);

    public int deleteGoods(int id);

    public int updateGoods(int id, String name, String price);

    public Goods selectGoods(int id);

    public List<Goods> selectAllGoods();
}
