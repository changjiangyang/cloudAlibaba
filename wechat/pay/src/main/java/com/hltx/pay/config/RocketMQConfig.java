package com.hltx.pay.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * User: ycj
 * Date: 2020/8/10
 * Time: 18:06
 * Description:
 */
@Component
@ConfigurationProperties(prefix = "wechat.rocket")
public class RocketMQConfig {

    private String topicname;

    private boolean shortmessage;

    private boolean email;

    private boolean templatemessage;

    public String getTopicname() {
        return topicname;
    }

    public void setTopicname(String topicname) {
        this.topicname = topicname;
    }

    public boolean isShortmessage() {
        return shortmessage;
    }

    public void setShortmessage(boolean shortmessage) {
        this.shortmessage = shortmessage;
    }

    public boolean isEmail() {
        return email;
    }

    public void setEmail(boolean email) {
        this.email = email;
    }

    public boolean isTemplatemessage() {
        return templatemessage;
    }

    public void setTemplatemessage(boolean templatemessage) {
        this.templatemessage = templatemessage;
    }
}
