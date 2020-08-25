package com.hltx.pay.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConstants;
import com.github.wxpay.sdk.WXPayUtil;
import com.hltx.pay.config.WechatConfig;
import com.hltx.pay.service.WechatPayService;
import com.hltx.pay.util.IpUtils;
import com.hltx.tool.HttpUtils;
import com.hltx.tool.VerificationCode;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: ycj
 * Date: 2020/8/10
 * Time: 12:08
 * Description:
 */

@Service("wechatPayService")
public class WechatPayServiceImpl implements WechatPayService {
    @Resource
    private RocketMQTemplate rocketMQTemplate;
    @Autowired
    WechatConfig wechatConfig;
    @Autowired
    WechatConfig wxConfig;

    @Override
    public Map<String,String> unifiedOrder(Map<String, String> data) {
        data.put("notify_url",wechatConfig.getNotify_url());
        data.put("fee_type","CNY");
        data.put("spbill_create_ip", IpUtils.getIp());
        data.put("sub_mch_id",wechatConfig.getSub_mch_id());
        WXPay wxpay = new WXPay( wxConfig.getconfig());
        try {
            Map<String,String> resp=wxpay.unifiedOrder(data);
            return resp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 处理支付成功逻辑
     * @return
     */
    public Map<String,String> payNotify(){
        Message<String> message = MessageBuilder.withPayload("message").build();
        TransactionSendResult sendResult = rocketMQTemplate.sendMessageInTransaction("producer_group_txmsg_bank1", message,  null);
        return null;
    }

    @Override
    public String sendMessage(Map<String,String> mess) {
        rocketMQTemplate.convertAndSend("test-topic", mess);
        return "SUCCESS";
    }

    @Override
    public Map<String, String> orderQuery(String out_trade_no) {
        WXPay wxpay = new WXPay( wxConfig.getconfig());
        Map<String, String> data = new HashMap<String, String>();
        data.put("out_trade_no", out_trade_no);
        data.put("sub_mch_id",wechatConfig.getSub_mch_id());
        Map<String, String> map = null;
        try {
            map = wxpay.orderQuery(data);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }

    @Override
    public  Map<String, String> refund(String out_trade_no,Integer total_fee,String transaction_id,Integer refund_fee,
                                       String notify_url) {
        WXPay wxpay = new WXPay( wxConfig.getconfig());
        Map<String, String> data = new HashMap<String, String>();
        data.put("out_trade_no", out_trade_no);
        data.put("sub_mch_id",wechatConfig.getSub_mch_id());
        data.put("total_fee",total_fee+"");
        data.put("out_refund_no", transaction_id);
        data.put("refund_fee",refund_fee+"");
        Map<String, String> map = null;
        try {
            map = wxpay.refund(data);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }

    @Override
    public Map<String, String> paySign(String preid) {
        Map<String,String> map=new HashMap<>();
        map.put("appId",wechatConfig.getAppid());
        map.put("timeStamp",String.valueOf(System.currentTimeMillis()/1000));
        map.put("nonceStr", VerificationCode.getrandom(32));
        map.put("package","");
        map.put("signType",preid);
        try {
           String paysign= WXPayUtil.generateSignature(map,wechatConfig.getCertKey());
           map.put("paySign",paysign);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String,String> map1=new HashMap<>();
            map1.put("except",e.getMessage());
        }
        return map;
    }

    @Override
    public void profitsharingaddreceiver(String type, String account, String relation_type) {
        WXPay wxpay = new WXPay( wxConfig.getconfig(),WXPayConstants.SignType.HMACSHA256);
        //System.out.println(wxpay.s);
        Map<String,String> map=new HashMap<>();
        map.put("mch_id",wechatConfig.getMchID());
        map.put("sub_mch_id",wechatConfig.getSub_mch_id());
        map.put("appid",wechatConfig.getAppid());
        map.put("sign_type","HMAC-SHA256");
        String nonce_str=VerificationCode.getrandom(16);
        System.out.println(nonce_str);
        map.put("nonce_str",nonce_str);
        try {

            Map<String,String> jsonmap=new HashMap<>();
            jsonmap.put("type",type);
            jsonmap.put("account",account);
            jsonmap.put("relation_type",relation_type);
            jsonmap.put("name","号令天下电子科技有限责任公司");
            String json= JSONObject.toJSONString(jsonmap);
            map.put("receiver",json);
            String paysign= WXPayUtil.generateSignature(map,wechatConfig.getCertKey(),WXPayConstants.SignType.HMACSHA256);
            System.out.println(paysign);
            map.put("sign",paysign);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String res = wxpay.requestWithoutCert("https://api.mch.weixin.qq.com/pay/profitsharingaddreceiver",
                    map,1000,1000);
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Map<String,String> profitsharing(String transaction_id, String out_order_no) {
        List<Map<String,Object>> mapList=new ArrayList<>();
        Map<String,Object > map=new HashMap<>();
        map.put("type","MERCHANT_ID");
        map.put("account","1598199921");
        map.put("amount",1);
        map.put("description","分到商户");
        mapList.add(map);
        Map<String ,String> resbody=new HashMap<>();
        resbody.put("mch_id",wechatConfig.getMchID());
        resbody.put("sub_mch_id",wechatConfig.getSub_mch_id());
        resbody.put("appid",wechatConfig.getAppid());
        resbody.put("nonce_str",VerificationCode.getrandom(16));
        resbody.put("sign_type","HMAC-SHA256");
        resbody.put("transaction_id",transaction_id);
        resbody.put("out_order_no",out_order_no);
        String rece=JSONObject.toJSONString(mapList);
        resbody.put("receivers",rece);
        try {
            String paysign= WXPayUtil.generateSignature(resbody,wechatConfig.getCertKey(),WXPayConstants.SignType.HMACSHA256);
            resbody.put("sign",paysign);
            WXPay wxpay = new WXPay(wechatConfig.getconfig());
            String res=wxpay.requestWithCert("https://api.mch.weixin.qq.com/secapi/pay/profitsharing",resbody,10000,10000);
            System.out.println(res);
            Map<String,String> map1=WXPayUtil.xmlToMap(res);
            return map1;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
