package com.hltx.mp.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Carproducet implements Serializable {
    private Integer id;

    private Integer proid;

    private Date addtime;

    private Integer number;

    private BigDecimal price;

    private BigDecimal money;

    private String proname;

    private String describe;

    private String thumbnail;

    private String carid;

    public String getCarid() {
        return carid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setCarid(String carid) {
        this.carid = carid;
    }

    @Override
    public String toString() {
        return "Carproducet{" +
                "id=" + id +
                ", proid=" + proid +
                ", addtime=" + addtime +
                ", number=" + number +
                ", price=" + price +
                ", money=" + money +
                ", proname='" + proname + '\'' +
                ", describe='" + describe + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", carid='" + carid + '\'' +
                '}';
    }
}