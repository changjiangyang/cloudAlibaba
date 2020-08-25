package com.hltx.mp.beans;

import java.io.Serializable;
import java.util.Date;

public class Integral implements Serializable {
    private Integer id;

    private String userid;

    private Date addtime;

    private Integer integral;

    private String come;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public String getCome() {
        return come;
    }

    public void setCome(String come) {
        this.come = come == null ? null : come.trim();
    }
}