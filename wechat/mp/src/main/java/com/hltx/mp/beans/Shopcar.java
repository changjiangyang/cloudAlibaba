package com.hltx.mp.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Shopcar implements Serializable {
    private String id;

    private String userid;

    private String username;

    private Date addtime;

    private BigDecimal sumprice;

    private Integer stauts;

    private List<Carproducet> carproducets;

    public List<Carproducet> getCarproducets() {
        return carproducets;
    }

    public void setCarproducets(List<Carproducet> carproducets) {
        this.carproducets = carproducets;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public BigDecimal getSumprice() {
        return sumprice;
    }

    public void setSumprice(BigDecimal sumprice) {
        this.sumprice = sumprice;
    }

    public Integer getStauts() {
        return stauts;
    }

    public void setStauts(Integer stauts) {
        this.stauts = stauts;
    }

    @Override
    public String toString() {
        return "Shopcar{" +
                "id='" + id + '\'' +
                ", userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", addtime=" + addtime +
                ", sumprice=" + sumprice +
                ", stauts=" + stauts +
                ", carproducets=" + carproducets +
                '}';
    }
}