package com.hltx.mp.mapper;

import com.hltx.mp.beans.Producet;
import com.hltx.mp.beans.Shopcar;

import java.util.List;

public interface ShopcarMapper {
    int deleteByPrimaryKey(String id);

    int insert(Shopcar record);

    int insertSelective(Shopcar record);

    Shopcar selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Shopcar record);

    int updateByPrimaryKey(Shopcar record);

    Shopcar getCarProducet(String userid);

}