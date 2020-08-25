package com.hltx.mp.mapper;

import com.hltx.mp.beans.Producet;

import java.util.List;

public interface ProducetMapper {
    int deleteByPrimaryKey(String proId);

    int insert(Producet record);

    int insertSelective(Producet record);

    Producet selectByPrimaryKey(Integer proId);

    int updateByPrimaryKeySelective(Producet record);

    int updateByPrimaryKeyWithBLOBs(Producet record);

    int updateByPrimaryKey(Producet record);

    int getCount();

    List<Producet> getByPage(Integer index, Integer pagesize);

}