package com.hltx.pay.service;

import java.util.Map;

/**
 * User: ycj
 * Date: 2020/8/10
 * Time: 11:51
 * Description:
 */
public interface WechatPayService {

    Map<String,String> unifiedOrder(Map<String,String> data);

    Map<String,String> payNotify();

    String sendMessage(Map<String,String> mess);

    Map<String ,String> orderQuery(String out_trade_no);

    Map<String, String> refund(String out_trade_no,Integer total_fee,String transaction_id,Integer refund_fee,
                               String notify_url);

    Map<String,String> paySign(String preid);

    void profitsharingaddreceiver(String type,String account,String relation_type);

    Map<String,String> profitsharing(String transaction_id,String out_order_no);
}
