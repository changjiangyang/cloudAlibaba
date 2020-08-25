package com.hltx.mp.mapper;

import com.hltx.mp.beans.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrdersMapper {
    int deleteByPrimaryKey(String id);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

    int addorders(@Param("orderList") List<Orders> ordersList);

    int getMyOrderCount(String userid);

    List<Orders> getOrdersByUserPage(String userid,Integer index,Integer pagesize);
}