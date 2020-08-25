package com.hltx.pay.controller;

import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayUtil;
import com.hltx.pay.config.WechatConfig;
import com.hltx.pay.service.WechatPayService;
import com.hltx.tool.BackCodeUtils;
import com.hltx.tool.UtilValidator;
import com.hltx.tool.VerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * User: ycj
 * Date: 2020/8/10
 * Time: 11:42
 * Description:
 */
@RequestMapping("pay")
@RestController
public class WechatPayController {

    @Autowired
    private WechatConfig wechatConfig;
    @Autowired
    WechatPayService wechatPayService;

    @RequestMapping(value = "gopay")
    public Map<String,Object> goPay(String packages){
        Map <String,String> map= wechatPayService.paySign(packages);
        return BackCodeUtils.getSuccess(map);
    }

    /**
     * 统一下单接口
     * @param body 商品描述
     * @param out_trade_no 商户订单号
     * @param trade_type 交易类型 JSAPI--JSAPI支付（或小程序支付）、NATIVE--Native支付、APP--app支付，MWEB--H5支付
     * @param product_id 商品ID
     * @param total_fee 标价金额
     * @return
     */
    @PostMapping(value = "unifiedOrder")
    public Map<String,Object> unifiedOrder(String body,String out_trade_no,String trade_type,
                                           String product_id,String total_fee,@RequestParam(defaultValue = "",required = false) String openid){
        Map<String,String> map=new HashMap<>();
        if (openid.equals("")){}else {map.put("openid",openid);}
        if (wechatConfig.isAccount_divided()){
            map.put("profit_sharing","Y");
        }
        map.put("body",body);
        map.put("out_trade_no",out_trade_no);
        map.put("trade_type",trade_type);
        map.put("product_id",product_id);
        map.put("total_fee",total_fee);
        Map<String,String> res=wechatPayService.unifiedOrder(map);
        if (res != null)
            return BackCodeUtils.getSuccess(res);
        else
            return BackCodeUtils.getFail();
    }

    @RequestMapping(value = "payNotify")
    public void payNotify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("微信支付成功调用回调URL");
        InputStream inStream = request.getInputStream();
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outSteam.write(buffer, 0, len);
        }
        System.out.println("~~~~~~~~~~~~~~~~付款成功~~~~~~~~~");
        String result = new String(outSteam.toByteArray(), "utf-8");
        Map<String, String> notifyMap = WXPayUtil.xmlToMap(result);
        WXPay wxpay = new WXPay(wechatConfig.getconfig());
        if (wxpay.isPayResultNotifySignatureValid(notifyMap)) {
            // 签名正确
            // 进行处理。
            // 注意特殊情况：订单已经退款，但收到了支付结果成功的通知，不应把商户侧订单状态从退款改成支付成功

            wechatPayService.sendMessage(notifyMap);
            //wechatPayService.profitsharing(notifyMap.get("transaction_id"),notifyMap.get("out_order_no"));

            OutputStream outputStream = null;
            try
            {
                outputStream = response.getOutputStream();
                outputStream.flush();
                outputStream.write(setXML("SUCCESS", "OK").getBytes());
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            System.out.println("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>");
        }else {
            // 签名错误，如果数据里没有sign字段，也认为是签名错误
        }

    }
    public static String setXML(String return_code, String return_msg)
    {
        return (new StringBuilder("<xml><return_code><![CDATA[")).append(return_code).append("]]></return_code><return_msg><![CDATA[").append(return_msg).append("]]></return_msg></xml>").toString();
    }
    /**
     * 发送消息
     * @param message 消息内容
     * @return
     */
    @PostMapping(value = "sendMessage")
    public Map<String,Object> sendMessage(String message){
        Map<String,String> map=new HashMap<>();
        map.put("data",message);
        return BackCodeUtils.getSuccess(wechatPayService.sendMessage(map));
    }

    @GetMapping(value = "orderQuery")
    public Map<String,Object> orderQuery(String out_trade_no){
        return BackCodeUtils.getSuccess(wechatPayService.orderQuery(out_trade_no));
    }

    @GetMapping(value = "refund")
    public Map<String,Object> refund(String out_trade_no,Integer total_fee,String transaction_id,Integer refund_fee,
                                     String notify_url){
        return BackCodeUtils.getSuccess(wechatPayService.refund(out_trade_no, total_fee, transaction_id, refund_fee, notify_url));
    }

    @PostMapping(value = "profitsharingaddreceiver")
    public Map<String,Object> profitsharingaddreceiver(String type,String account,String relation_type){
        wechatPayService.profitsharingaddreceiver(type, account, relation_type);
        return null;
    }

    @GetMapping(value = "profitsharing")
    public Map<String,Object> profitsharing(String transaction_id, String out_order_no)
    {
       Map<String,String> map = wechatPayService.profitsharing(transaction_id,out_order_no);

       return BackCodeUtils.getSuccess(map);
    }
}
