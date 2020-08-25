package com.hltx.pay.config;

import com.github.wxpay.sdk.WXPayConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * User: ycj
 * Date: 2020/8/10
 * Time: 11:40
 * Description:
 */
@Component
@ConfigurationProperties("wechat.pay")
public class WechatConfig {


    private String appid;

    private String mchID;

    private String sub_appid;

    private String sub_mch_id;

    private boolean account_divided;

    private String certPath;

    private String certKey;

    private Integer connectTimeOut;

    private Integer readTimeout;

    private String notify_url;

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMchID() {
        return mchID;
    }

    public void setMchID(String mchID) {
        this.mchID = mchID;
    }

    public String getSub_appid() {
        return sub_appid;
    }

    public void setSub_appid(String sub_appid) {
        this.sub_appid = sub_appid;
    }

    public String getSub_mch_id() {
        return sub_mch_id;
    }

    public void setSub_mch_id(String sub_mch_id) {
        this.sub_mch_id = sub_mch_id;
    }

    public boolean isAccount_divided() {
        return account_divided;
    }

    public void setAccount_divided(boolean account_divided) {
        this.account_divided = account_divided;
    }

    public String getCertPath() {
        return certPath;
    }

    public void setCertPath(String certPath) {
        this.certPath = certPath;
    }

    public String getCertKey() {
        return certKey;
    }

    public void setCertKey(String certKey) {
        this.certKey = certKey;
    }

    public Integer getConnectTimeOut() {
        return connectTimeOut;
    }

    public void setConnectTimeOut(Integer connectTimeOut) {
        this.connectTimeOut = connectTimeOut;
    }

    public Integer getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(Integer readTimeout) {
        this.readTimeout = readTimeout;
    }

    public WxConfig getconfig(){
        return new WxConfig();
    }

    public class WxConfig implements WXPayConfig{
        private byte[] certData;

        public WxConfig(){
            String path=getCertPath();
            File file=new File(path);
            try {
                InputStream inputStream=new FileInputStream(file);
                certData=new byte[(int)file.length()];
                inputStream.read(certData);
                inputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String getAppID() {
            return appid;
        }

        @Override
        public String getMchID() {
            return mchID;
        }

        @Override
        public String getKey() {
            return certKey;
        }

        @Override
        public InputStream getCertStream() {
            ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
            return certBis;
        }

        @Override
        public int getHttpConnectTimeoutMs() {
            return getConnectTimeOut();
        }

        @Override
        public int getHttpReadTimeoutMs() {
            return getReadTimeout();
        }
    }


}
