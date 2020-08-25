package com.hltx.mp.controller;

import com.hltx.mp.beans.Users;
import com.hltx.mp.config.UploadConfig;
import com.hltx.mp.service.UsersService;
import com.hltx.tool.BackCodeUtils;
import com.hltx.tool.PrimarykeyUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpQrCodeTicket;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: ycj
 * Date: 2020/8/17
 * Time: 15:56
 * Description:
 */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("user")
public class UsersController {

    WxMpService wxService;
    @Autowired
    UploadConfig uploadConfig;

    @Autowired
    UsersService usersService;

    @RequestMapping(value = "getUserInfo",method = RequestMethod.GET)
    public Map<String,Object> getUserInfo(String appid, String code){
        if (!this.wxService.switchover(appid)) {
            throw new IllegalArgumentException(String.format("未找到对应appid=[%s]的配置，请核实！", appid));
        }
        Map<String,Object> map=new HashMap<>();
        try {
            WxMpOAuth2AccessToken accessToken = wxService.oauth2getAccessToken(code);
            WxMpUser user = wxService.oauth2getUserInfo(accessToken, null);
            //map.put("user", user);
            Users users=new Users();
            users.setUsernick(user.getNickname());
            users.setOpenid(user.getOpenId());
            users.setAddresss(user.getCountry()+user.getProvince()+user.getCity());
            users.setSex(user.getSex());
            users.setHandimg(user.getHeadImgUrl());
            usersService.updateUsers(users);
            System.out.println(user.toString());
            return BackCodeUtils.getSuccess(user);
        } catch (WxErrorException e) {
            e.printStackTrace();
            return BackCodeUtils.getExcept();
        }
    }

    @GetMapping(value = "getQrcode")
    public Map<String,Object> getQrcode(String appid,String openid){
        if (!this.wxService.switchover(appid)) {
            throw new IllegalArgumentException(String.format("未找到对应appid=[%s]的配置，请核实！", appid));
        }
        try {
            WxMpQrCodeTicket ticket = wxService.getQrcodeService().qrCodeCreateLastTicket(openid);
            File file = wxService.getQrcodeService().qrCodePicture(ticket);
            String wirtename= PrimarykeyUtil.getUUID()+".jpg";
            String writepath=uploadConfig.getQrcode()+wirtename;
            File write= new File(writepath);
            if (write.exists()){
                write.delete();//删除对应的文件，从磁盘中删除
                write = new File(writepath);
            }else{
                write.createNewFile();
            }
            FileInputStream in = new FileInputStream(file);
            FileOutputStream out = new FileOutputStream(write);// 指定要写入的图片
            int n = 0;// 每次读取的字节长度
            byte[] bb = new byte[1024];// 存储每次读取的内容
            while ((n = in.read(bb)) != -1) {
                out.write(bb, 0, n);// 将读取的内容，写入到输出流当中
            }
            out.close();
            in.close();
            int t = usersService.updateQrcode(openid,wirtename);
            if (t>0) return BackCodeUtils.getSuccess(wirtename);
            else return BackCodeUtils.getFail();
        } catch (WxErrorException | IOException e) {
            e.printStackTrace();
            return BackCodeUtils.getExcept();
        }
    }

    @GetMapping(value = "getCount")
    public Map<String,Object> getCount(){
        return BackCodeUtils.getSuccess(usersService.getCount());
    }

    @GetMapping(value = "getUsersPage")
    public Map<String,Object> getUsersPage(@RequestParam(defaultValue = "1",required = false) Integer page,
                                           @RequestParam(defaultValue = "15",required = false) Integer limit){
        Integer count=usersService.getCount();
        List<Users> list=usersService.getUsersPage((page-1)*limit, limit);
        if (list==null)
            return BackCodeUtils.getNan();
        if (list.size()<=0)
            return BackCodeUtils.getNan();
        else {
            Map<String,Object> map=new HashMap<>();
            map.put("count",count);
            map.put("data",list);
            map.put("code",10000);
            map.put("message","SUCCESS");
            return map;
        }
    }

}
