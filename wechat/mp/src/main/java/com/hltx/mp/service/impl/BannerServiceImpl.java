package com.hltx.mp.service.impl;

import com.hltx.mp.beans.Banner;
import com.hltx.mp.mapper.BannerMapper;
import com.hltx.mp.service.BannerService;
import com.hltx.mp.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: ycj
 * Date: 2020/8/17
 * Time: 12:21
 * Description:
 */
@Service("bannerService")
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerMapper bannerMapper;
    @Autowired
    RedisUtils redisUtils;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        if (redisUtils.get("allbanner")!=null)
            redisUtils.del("allbanner");
        return bannerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Banner record) {
        return bannerMapper.insert(record);
    }

    @Override
    public int insertSelective(Banner record) {
        if (redisUtils.get("allbanner")!=null)
            redisUtils.del("allbanner");
        return bannerMapper.insertSelective(record);
    }

    @Override
    public Banner selectByPrimaryKey(Integer id) {
        return bannerMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Banner record) {
        return bannerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Banner record) {
        return bannerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Banner> getAll() {
        if (redisUtils.get("allbanner")==null){
            List<Banner> list= bannerMapper.getAll();
            redisUtils.set("allbanner",list);
            return list;
        }
        else{
            return (List<Banner>)redisUtils.get("allbanner");
        }
    }
}
