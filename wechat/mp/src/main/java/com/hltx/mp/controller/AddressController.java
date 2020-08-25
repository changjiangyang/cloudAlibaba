package com.hltx.mp.controller;

import com.hltx.mp.beans.Address;
import com.hltx.mp.service.AddressService;
import com.hltx.tool.BackCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * User: ycj
 * Date: 2020/8/18
 * Time: 13:46
 * Description:
 */
@RestController
@RequestMapping("address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @RequestMapping(value = "getCount",method = RequestMethod.GET)
    public Map<String,Object> getCount(){
        int t=addressService.getCount();
        if (t>0)
            return BackCodeUtils.getSuccess(t);
        else
            return BackCodeUtils.getNan();
    }

    @GetMapping(value = "getByPage")
    public Map<String,Object> getByPage(@RequestParam(defaultValue = "0",required = false) Integer index,
                                        @RequestParam(defaultValue = "15",required = false) Integer pagesize){
        List<Address> list=addressService.getByPage(index, pagesize);
        if (list==null)
            return BackCodeUtils.getNan();
        if (list.size()<=0)
            return BackCodeUtils.getNan();
        else
            return BackCodeUtils.getSuccess(list);
    }

    @GetMapping(value = "getMyDef")
    public Map<String ,Object> getMyDef(String userid){
        Address address=addressService.getMyDefaultAddress(userid);
        if (address==null){
            return BackCodeUtils.getNan();
        }else {
            return BackCodeUtils.getSuccess(address);
        }
    }

    @GetMapping(value = "getMyAddress")
    public Map<String,Object> getMyAddress(String userid){
        List<Address> list=addressService.getMyAddress(userid);
        if (list==null)
            return BackCodeUtils.getNan();
        if (list.size()<=0)
            return BackCodeUtils.getNan();
        else
            return BackCodeUtils.getSuccess(list);
    }

    @GetMapping(value = "updateDef")
    public Map<String,Object> updateDef(String userid ,Integer id){
        if (addressService.updateDef(userid, id)>0)
            return BackCodeUtils.getSuccess("SUCCESS");
        else
            return BackCodeUtils.getFail();
    }

    @PostMapping(value = "addAddress")
    public Map<String,Object> addAddress(Address address){
        if (address.getDef()==1){
            addressService.cannDef(address.getUserid());
        }
        int t=addressService.insertSelective(address);
        if (t>0){
            return BackCodeUtils.getSuccess("SUCCESS");
        }else {
            return BackCodeUtils.getFail();
        }
    }

    @GetMapping(value = "deleteAddress")
    public Map<String,Object> deleteAddress(Integer id){
        int t = addressService.deleteByPrimaryKey(id);
        if (t>0){
            return BackCodeUtils.getSuccess("SUCCESS");
        }else {
            return BackCodeUtils.getFail();
        }
    }


}
