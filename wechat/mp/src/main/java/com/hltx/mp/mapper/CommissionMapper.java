package com.hltx.mp.mapper;

import com.hltx.mp.beans.Commission;

public interface CommissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Commission record);

    int insertSelective(Commission record);

    Commission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Commission record);

    int updateByPrimaryKey(Commission record);
}