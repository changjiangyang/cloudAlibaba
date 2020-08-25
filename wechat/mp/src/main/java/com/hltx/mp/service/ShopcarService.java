package com.hltx.mp.service;

import com.hltx.mp.beans.Carproducet;
import com.hltx.mp.beans.Shopcar;

/**
 * User: ycj
 * Date: 2020/8/18
 * Time: 15:44
 * Description:
 */
public interface ShopcarService {

    Shopcar initShopCar(String userid);

    Shopcar getMyCar(String userid);

    int clearMyCar(String userid,String carid);

    int addProduct(Carproducet carproducet,String userid);

    int removePro(Integer carProid,String userid);

    int updatePronum(Integer carProid,Integer number,String userid);


}
