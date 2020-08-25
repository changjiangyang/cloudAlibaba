package com.hltx.mp.service.impl;

import com.hltx.mp.beans.Carproducet;
import com.hltx.mp.beans.Orders;
import com.hltx.mp.beans.Shopcar;
import com.hltx.mp.mapper.OrdersMapper;
import com.hltx.mp.mapper.ShopcarMapper;
import com.hltx.mp.service.OrdersService;
import com.hltx.mp.util.RedisUtils;
import com.hltx.tool.PrimarykeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: ycj
 * Date: 2020/8/19
 * Time: 17:29
 * Description:
 */
@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    OrdersMapper ordersMapper;
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    ShopcarMapper shopcarMapper;

    @Override
    public int addOrders(String userid, String carid,String name,String phone,String address) {
        String key="shopcar"+userid;
        Shopcar shopcar=null;
        if (redisUtils.get(key)!=null){
            shopcar= (Shopcar) redisUtils.get(key);
        }else {
            shopcar=shopcarMapper.getCarProducet(userid);
        }
        List<Orders> orders=new ArrayList<>();
        List<Carproducet> carproducets=shopcar.getCarproducets();
        for (Carproducet carproducet:carproducets){
            Orders orders1=new Orders();
            orders1.setId(PrimarykeyUtil.getUUID());
            orders1.setAddress(address);
            orders1.setAddtime(new Date());
            orders1.setMoney(carproducet.getMoney());
            orders1.setNumber(carproducet.getNumber());
            orders1.setName(name);
            orders1.setPhone(phone);
            orders1.setThumbnail(carproducet.getThumbnail());
            orders1.setPrice(carproducet.getPrice());
            orders1.setUserid(userid);
            orders.add(orders1);
        }
        int t=ordersMapper.addorders(orders);
        return t;
    }

    @Override
    public int updateOrders(Orders orders) {
        return ordersMapper.updateByPrimaryKeySelective(orders);
    }

    @Override
    public int deletOrders(String oid) {
        return ordersMapper.deleteByPrimaryKey(oid);
    }

    @Override
    public Orders getOrderDetail(String oid) {
        return ordersMapper.selectByPrimaryKey(oid);
    }

    @Override
    public int getMyOrderCount(String userid) {
        return ordersMapper.getMyOrderCount(userid);
    }

    @Override
    public List<Orders> getOrdersByUserPage(String userid, Integer index, Integer pagesize) {
        return ordersMapper.getOrdersByUserPage(userid, index, pagesize);
    }


}
