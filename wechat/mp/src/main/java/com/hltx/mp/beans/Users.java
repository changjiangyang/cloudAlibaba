package com.hltx.mp.beans;

import java.io.Serializable;
import java.util.Date;

public class Users implements Serializable {
    private String id;

    private String usernick;

    private String openid;

    private String phone;

    private Date addtime;

    private String logname;

    private String password;

    private String unid;

    private String qrcode;

    private Integer usertype;

    private String superid1;

    private String superid2;

    private String superid3;

    private String supername1;

    private String supername2;

    private String supername3;

    private String addresss;

    private Integer sex;

    private String handimg;

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getHandimg() {
        return handimg;
    }

    public void setHandimg(String handimg) {
        this.handimg = handimg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsernick() {
        return usernick;
    }

    public void setUsernick(String usernick) {
        this.usernick = usernick;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getLogname() {
        return logname;
    }

    public void setLogname(String logname) {
        this.logname = logname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUnid() {
        return unid;
    }

    public void setUnid(String unid) {
        this.unid = unid;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    public String getSuperid1() {
        return superid1;
    }

    public void setSuperid1(String superid1) {
        this.superid1 = superid1;
    }

    public String getSuperid2() {
        return superid2;
    }

    public void setSuperid2(String superid2) {
        this.superid2 = superid2;
    }

    public String getSuperid3() {
        return superid3;
    }

    public void setSuperid3(String superid3) {
        this.superid3 = superid3;
    }

    public String getSupername1() {
        return supername1;
    }

    public void setSupername1(String supername1) {
        this.supername1 = supername1;
    }

    public String getSupername2() {
        return supername2;
    }

    public void setSupername2(String supername2) {
        this.supername2 = supername2;
    }

    public String getSupername3() {
        return supername3;
    }

    public void setSupername3(String supername3) {
        this.supername3 = supername3;
    }

    public String getAddresss() {
        return addresss;
    }

    public void setAddresss(String addresss) {
        this.addresss = addresss;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id='" + id + '\'' +
                ", usernick='" + usernick + '\'' +
                ", openid='" + openid + '\'' +
                ", phone='" + phone + '\'' +
                ", addtime=" + addtime +
                ", logname='" + logname + '\'' +
                ", password='" + password + '\'' +
                ", unid='" + unid + '\'' +
                ", qrcode='" + qrcode + '\'' +
                ", usertype=" + usertype +
                ", superid1='" + superid1 + '\'' +
                ", superid2='" + superid2 + '\'' +
                ", superid3='" + superid3 + '\'' +
                ", supername1='" + supername1 + '\'' +
                ", supername2='" + supername2 + '\'' +
                ", supername3='" + supername3 + '\'' +
                ", addresss='" + addresss + '\'' +
                ", sex=" + sex +
                ", handimg='" + handimg + '\'' +
                '}';
    }
}