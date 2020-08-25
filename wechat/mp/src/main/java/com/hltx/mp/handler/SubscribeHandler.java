package com.hltx.mp.handler;

import java.util.Date;
import java.util.Map;

import com.hltx.mp.beans.Users;
import com.hltx.mp.builder.TextBuilder;
import com.hltx.mp.service.UsersService;
import com.hltx.tool.PrimarykeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@Component
public class SubscribeHandler extends AbstractHandler {

    @Autowired
    private UsersService usersService;

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) throws WxErrorException {

        this.logger.info("新关注用户 OPENID: " + wxMessage.getFromUser());

        // 获取微信用户基本信息
        try {
            WxMpUser userWxInfo = weixinService.getUserService()
                .userInfo(wxMessage.getFromUser(), null);
            if (userWxInfo != null) {
                // TODO 可以添加关注用户到本地数据库
                // TODO 非扫码加入
                String key=wxMessage.getEventKey();
                if (key.equals("")){
                    //新用户扫码关注
                    String openid=wxMessage.getFromUser();
                    Users users=null;
                    users=usersService.getUsersByOpenid(openid);
                    if (users==null){
                        users=new Users();
                        users.setId(PrimarykeyUtil.getUUID());
                        users.setOpenid(openid);
                        users.setAddtime(new Date());
                        usersService.insertSelective(users);
                    }else {
                        // TODO 平台已存在用户信息，不做任何处理
                    }
                }
            }
        } catch (WxErrorException e) {
            if (e.getError().getErrorCode() == 48001) {
                this.logger.info("该公众号没有获取用户信息权限！");
            }
        }


        WxMpXmlOutMessage responseResult = null;
        try {
            responseResult = this.handleSpecial(wxMessage);
        } catch (Exception e) {
            this.logger.error(e.getMessage(), e);
        }

        if (responseResult != null) {
            return responseResult;
        }

        try {
            return new TextBuilder().build("感谢关注", wxMessage, weixinService);
        } catch (Exception e) {
            this.logger.error(e.getMessage(), e);
        }

        return null;
    }

    /**
     * 处理特殊请求，比如如果是扫码进来的，可以做相应处理
     */
    private WxMpXmlOutMessage handleSpecial(WxMpXmlMessage wxMessage)
        throws Exception {
        //TODO 扫码关注系统
        String key=wxMessage.getEventKey();
        if (key.indexOf("qrscene_")>-1){
            //新用户扫码关注

            String superopenid=key.replace("qrscene_","");
            Users superusers= usersService.getUsersByOpenid(superopenid);
           // String superid=superusers.getId();
            String supername=superusers.getUsernick();
            String openid=wxMessage.getFromUser();
            Users users=new Users();
            users.setId(PrimarykeyUtil.getUUID());
            users.setSuperid1(superopenid);
            users.setAddtime(new Date());
            users.setSupername1(supername);
            users.setOpenid(openid);
            usersService.insertSelective(users);
        }
        return null;
    }

}
