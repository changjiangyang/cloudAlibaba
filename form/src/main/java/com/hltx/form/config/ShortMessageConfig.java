package com.hltx.form.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * User: ycj
 * Date: 2020/8/14
 * Time: 8:49
 * Description:
 */
@Component
@ConfigurationProperties(prefix = "shortmessage.smwg")
public class ShortMessageConfig {

    private String url;

    private String action;

    private String account;

    private String password;

    private String extno;

    private String rt;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getExtno() {
        return extno;
    }

    public void setExtno(String extno) {
        this.extno = extno;
    }

    public String getRt() {
        return rt;
    }

    public void setRt(String rt) {
        this.rt = rt;
    }
}
