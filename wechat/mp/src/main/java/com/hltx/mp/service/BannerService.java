package com.hltx.mp.service;

import com.hltx.mp.beans.Banner;

import java.util.List;

public interface BannerService {

    int deleteByPrimaryKey(Integer id);

    int insert(Banner record);

    int insertSelective(Banner record);

    Banner selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKey(Banner record);

    List<Banner> getAll();
}
