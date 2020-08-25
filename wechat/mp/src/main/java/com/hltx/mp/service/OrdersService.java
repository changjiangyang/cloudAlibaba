package com.hltx.mp.service;

import com.hltx.mp.beans.Orders;
import com.hltx.mp.beans.Shopcar;

import java.util.List;

/**
 * User: ycj
 * Date: 2020/8/19
 * Time: 17:28
 * Description:
 */
public interface OrdersService {

    int addOrders(String userid, String carid,String name,String phone,String address);

    int updateOrders(Orders orders);

    int deletOrders(String oid);

    Orders getOrderDetail(String oid);

    int getMyOrderCount(String userid);

    List<Orders> getOrdersByUserPage(String userid,Integer index,Integer pagesize);
}
