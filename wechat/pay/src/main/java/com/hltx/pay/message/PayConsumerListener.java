package com.hltx.pay.message;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * User: ycj
 * Date: 2020/8/10
 * Time: 17:32
 * Description:
 */
@Component
// topic需要和生产者的topic一致，consumerGroup属性是必须指定的，内容可以随意
@RocketMQMessageListener(topic = "test-topic", consumerGroup = "consumer-group")
public class PayConsumerListener implements RocketMQListener<Map<String,String>> {

    @Override
    public void onMessage(Map<String,String> s) {
        System.out.println(s);
    }
}
