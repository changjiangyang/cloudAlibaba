package com.hltx.mp.service.impl;

import com.hltx.mp.beans.Carproducet;
import com.hltx.mp.beans.Shopcar;
import com.hltx.mp.mapper.CarproducetMapper;
import com.hltx.mp.mapper.ShopcarMapper;
import com.hltx.mp.service.ShopcarService;
import com.hltx.mp.util.RedisUtils;
import com.hltx.tool.PrimarykeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * User: ycj
 * Date: 2020/8/18
 * Time: 17:40
 * Description:
 */
@Service("shopcarService")
public class ShopcarServiceImpl implements ShopcarService {

    @Autowired
    ShopcarMapper shopcarMapper;
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    CarproducetMapper carproducetMapper;

    @Override
    public Shopcar initShopCar(String userid) {
        Shopcar shopcar=new Shopcar();
        shopcar.setId(PrimarykeyUtil.getUUID());
        shopcar.setUserid(userid);
        shopcar.setAddtime(new Date());
        int t=shopcarMapper.insertSelective(shopcar);
        if(t>0){
            return shopcar;
        }
            return null;
    }

    @Override
    public Shopcar getMyCar(String userid) {
        String key="shopcar"+userid;
        if (redisUtils.get(key)!=null){
            return (Shopcar) redisUtils.get(key);
        }else {
            Shopcar shopcar=shopcarMapper.getCarProducet(userid);
            redisUtils.set(key,shopcar);
            return shopcar;
        }
    }

    @Override
    public int clearMyCar(String userid, String carid) {
        String key="shopcar"+userid;
        int t=carproducetMapper.clearMyCar(carid);
        if (t>0){
            if (redisUtils.get(key)!=null)
                redisUtils.del(key);
            return t;
        }
        return 0;
    }

    @Override
    public int addProduct(Carproducet carproducet,String userid) {
        String key="shopcar"+userid;
        int t= carproducetMapper.insertSelective(carproducet);
        if (t>0){
            Shopcar shopcar= (Shopcar) redisUtils.get(key);
            if (shopcar!=null){
                List<Carproducet> list=shopcar.getCarproducets();
                list.add(carproducet);
                shopcar.setCarproducets(list);
                redisUtils.set(key,shopcar);
                return t;
            }
        }
        return 0;
    }

    @Override
    public int removePro(Integer carProid,String userid) {
        int t= carproducetMapper.deleteByPrimaryKey(carProid);
        if (t>0){
            String key="shopcar"+userid;
            if (redisUtils.get(key)!=null)
                redisUtils.del(key);
            return t;
        }
        return 0;
    }

    @Override
    public int updatePronum(Integer carProid, Integer number,String userid) {
        Carproducet carproducet=new Carproducet();
        carproducet.setId(carProid);
        int t = carproducetMapper.updateByPrimaryKeySelective(carproducet);
        if (t>0){
            String key="shopcar"+userid;
            if (redisUtils.get(key)!=null)
                redisUtils.del(key);
            return t;
        }
        return 0;
    }
}
