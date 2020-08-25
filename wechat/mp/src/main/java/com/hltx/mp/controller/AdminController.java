package com.hltx.mp.controller;

import com.hltx.mp.beans.Admin;
import com.hltx.mp.service.AdminService;
import com.hltx.tool.BackCodeUtils;
import com.hltx.tool.Encription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * User: ycj
 * Date: 2020/8/19
 * Time: 15:03
 * Description:
 */
@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public Map<String,Object> login(String logname,String pwd){
        Admin admin=adminService.login(logname);
        if (admin.getPwd().equals(Encription.md5(pwd))){
            return BackCodeUtils.getSuccess(admin);
        }else {
            return BackCodeUtils.getOtherFail("账号或密码错误");
        }

    }

}
