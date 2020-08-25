package com.hltx.mp.controller;

import com.hltx.mp.beans.Carproducet;
import com.hltx.mp.beans.Shopcar;
import com.hltx.mp.service.ShopcarService;
import com.hltx.tool.BackCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * User: ycj
 * Date: 2020/8/18
 * Time: 15:40
 * Description:
 */
@RestController
@RequestMapping("shopcar")
public class ShopcarController {

    @Autowired
    ShopcarService shopcarService;

    @RequestMapping(value = "getMyCar",method = {RequestMethod.GET,RequestMethod.POST})
    public Map<String,Object> getMyCar(String userid){
        Shopcar shopcar = shopcarService.getMyCar(userid);
        if (shopcar != null){
            return BackCodeUtils.getSuccess(shopcar);
        }else {
            return BackCodeUtils.getNan();
        }
    }

    @GetMapping(value = "clearMyCar")
    public Map<String,Object> clearMyCar(String carid,String userid){
        int t=shopcarService.clearMyCar(carid, userid);
        if (t>0){
            return BackCodeUtils.getSuccess("SUCCESS");
        }else {
            return BackCodeUtils.getFail();
        }
    }

    @PostMapping(value = "addCarProducet")
    public Map<String,Object> addCarProducet(Carproducet carproducet,String userid){
        Shopcar shopcar=shopcarService.getMyCar(userid);
        if (shopcar==null){
            shopcar=shopcarService.initShopCar(userid);
        }
        carproducet.setCarid(shopcar.getId());
        int t=shopcarService.addProduct(carproducet,userid);
        if (t>0){
            return BackCodeUtils.getSuccess("SUCCESS");
        }else {
            return BackCodeUtils.getFail();
        }
    }

}
