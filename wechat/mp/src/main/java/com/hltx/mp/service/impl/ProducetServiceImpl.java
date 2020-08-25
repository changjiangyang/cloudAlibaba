package com.hltx.mp.service.impl;

import com.hltx.mp.beans.Producet;
import com.hltx.mp.mapper.ProducetMapper;
import com.hltx.mp.service.ProducetService;
import com.hltx.mp.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: ycj
 * Date: 2020/8/18
 * Time: 9:27
 * Description:
 */
@Service("producetService")
public class ProducetServiceImpl implements ProducetService {

    @Autowired
    ProducetMapper producetMapper;
    @Autowired
    RedisUtils redisUtils;

    @Override
    public int deleteByPrimaryKey(String proId) {
        return producetMapper.deleteByPrimaryKey(proId);
    }

    @Override
    public int insert(Producet record) {
        return producetMapper.insert(record);
    }

    @Override
    public int insertSelective(Producet record) {
        return producetMapper.insertSelective(record);
    }

    @Override
    public Producet selectByPrimaryKey(Integer proId) {
        if (redisUtils.get("pro"+proId)==null){
            Producet producet=producetMapper.selectByPrimaryKey(proId);
            redisUtils.set("pro"+proId,producet);
            return producet;
        }
        else
            return (Producet) redisUtils.get("pro"+proId);
    }

    @Override
    public int updateByPrimaryKeySelective(Producet record) {
        int t = producetMapper.updateByPrimaryKeySelective(record);
        if (t>0){
            if (redisUtils.get("pro"+record.getProId())!= null){
                redisUtils.del("pro"+record.getProId());
            }
            return t;
        }
        return 0;
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(Producet record) {
        int t = producetMapper.updateByPrimaryKeyWithBLOBs(record);
        if (t>0){
            if (redisUtils.get("pro"+record.getProId())!= null){
                redisUtils.del("pro"+record.getProId());
            }
            return t;
        }
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Producet record) {
        int t = producetMapper.updateByPrimaryKey(record);
        if (t>0){
            if (redisUtils.get("pro"+record.getProId())!= null){
                redisUtils.del("pro"+record.getProId());
            }
            return t;
        }
        return 0;
    }

    @Override
    public int getCount() {
        int t = producetMapper.getCount();
        if (t>0){
            redisUtils.set("procount",t);
            return t;
        }
        return 0;
    }

    @Override
    public List<Producet> getByPage(Integer index, Integer pagesize) {
        return producetMapper.getByPage(index, pagesize);
    }
}
