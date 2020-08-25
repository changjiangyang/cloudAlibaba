package com.hltx.mp.mapper;

import com.hltx.mp.beans.Carproducet;

public interface CarproducetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Carproducet record);

    int insertSelective(Carproducet record);

    Carproducet selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Carproducet record);

    int updateByPrimaryKey(Carproducet record);

    int clearMyCar(String carid);
}