package com.hltx.mp.service.impl;

import com.hltx.mp.beans.Address;
import com.hltx.mp.mapper.AddressMapper;
import com.hltx.mp.service.AddressService;
import com.hltx.mp.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: ycj
 * Date: 2020/8/18
 * Time: 11:40
 * Description:
 */
@Service("addressService")
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressMapper addressMapper;
    @Autowired
    RedisUtils redisUtils;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        int t= addressMapper.deleteByPrimaryKey(id);
        if (t>0){
            if (redisUtils.get("address"+id)!= null)
                redisUtils.del("address"+id);
            return t;
        }
        return 0;
    }

    @Override
    public int insert(Address record) {
        int t = addressMapper.insert(record);
        if (t>0) {
            String key="addcount";
            if (redisUtils.get(key) != null){
                redisUtils.del(key);
            }
            return t;
        }
        return 0;
    }

    @Override
    public int insertSelective(Address record) {
        int t = addressMapper.insertSelective(record);
        if (t>0) {
            String key="addcount";
            if (redisUtils.get(key) != null){
                redisUtils.del(key);
            }
            return t;
        }
        return 0;
    }

    @Override
    public Address selectByPrimaryKey(Integer id) {
        Address address=addressMapper.selectByPrimaryKey(id);
        redisUtils.set("address"+address.getId(),address);
        return address;
    }

    @Override
    public int updateByPrimaryKeySelective(Address record) {
        int t= addressMapper.updateByPrimaryKeySelective(record);
        if (t>0){
            if (redisUtils.get("address"+record.getId())!= null)
                redisUtils.del("address"+record.getId());
            return t;
        }
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Address record) {
        int t= addressMapper.updateByPrimaryKeySelective(record);
        if (t>0){
            if (redisUtils.get("address"+record.getId())!= null)
                redisUtils.del("address"+record.getId());
            return t;
        }
        return 0;
    }

    @Override
    public Address getMyDefaultAddress(String userid) {
        String key="adddef"+userid;
        Address address = addressMapper.getMyDefaultAddress(userid);
        redisUtils.set(key,address);
        return address;
    }

    @Override
    public List<Address> getMyAddress(String userid) {
        String key="add"+userid;
        List<Address> list=addressMapper.getMyAddress(userid);
        redisUtils.set(key,list);
        return list;
    }

    @Override
    public int cannDef(String userid) {
        int t=addressMapper.cannDef(userid);
        if (t>0){
            String key="adddef"+userid;
            if (redisUtils.get(key)!= null)
                redisUtils.del(key);
            if (redisUtils.get("add"+userid)!= null)
                redisUtils.del("add"+userid);
            return t;
        }
        return 0;
    }

    @Override
    public int addDef(Integer id,String userid) {
        int t=addressMapper.addDef(id);
        Address address=addressMapper.selectByPrimaryKey(id);
        if (t>0){
            redisUtils.set("adddef"+address.getUserid(),address);
            return t;
        }
        return 0;
    }

    @Override
    public int getCount() {
        int t=addressMapper.getCount();
        redisUtils.set("addcount",t);
        return t;
    }

    @Override
    public List<Address> getByPage(Integer index, Integer pagesize) {
        List<Address> list=addressMapper.getByPage(index, pagesize);
        return list;
    }

    @Override
    @Transactional(rollbackFor = {RuntimeException.class,Error.class})
    public int updateDef(String userid, Integer id) {
        addressMapper.cannDef(userid);
        int t= addressMapper.addDef(id);
        Address address=addressMapper.selectByPrimaryKey(id);
        if (t>0){
            redisUtils.set("adddef"+address.getUserid(),address);
            return t;
        }
        return 0;
    }
}
