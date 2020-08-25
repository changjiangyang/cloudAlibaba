package com.hltx.mp.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Commission implements Serializable {
    private Integer id;

    private String userid;

    private Date addtime;

    private BigDecimal jine;

    private Integer status;

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

    public BigDecimal getJine() {
        return jine;
    }

    public void setJine(BigDecimal jine) {
        this.jine = jine;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCome() {
        return come;
    }

    public void setCome(String come) {
        this.come = come == null ? null : come.trim();
    }
}