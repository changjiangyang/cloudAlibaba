package com.hltx.mp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * User: ycj
 * Date: 2020/8/12
 * Time: 13:52
 * Description: 文件上传
 */
@Component
@ConfigurationProperties(prefix = "upload")
public class UploadConfig {

    String imgpath;
    long imgmaxsize;
    String qrcode;

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public long getImgmaxsize() {
        return imgmaxsize;
    }

    public void setImgmaxsize(long imgmaxsize) {
        this.imgmaxsize = imgmaxsize;
    }

}
