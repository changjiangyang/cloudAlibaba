package com.hltx.mp.service;

import com.hltx.mp.beans.Address;

import java.util.List;

public interface AddressService {

    int deleteByPrimaryKey(Integer id);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);

    Address getMyDefaultAddress(String userid);

    List<Address> getMyAddress(String userid);

    int cannDef(String userid);

    int addDef(Integer id,String userid);

    int getCount();

    List<Address> getByPage(Integer index,Integer pagesize);

    int updateDef(String userid,Integer id);
}
