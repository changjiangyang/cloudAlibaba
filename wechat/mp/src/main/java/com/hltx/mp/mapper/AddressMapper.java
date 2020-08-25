package com.hltx.mp.mapper;

import com.hltx.mp.beans.Address;

import java.util.List;

public interface AddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);

    Address getMyDefaultAddress(String userid);

    List<Address> getMyAddress(String userid);

    int cannDef(String userid);

    int addDef(Integer id);

    int getCount();

    List<Address> getByPage(Integer index,Integer pagesize);
}