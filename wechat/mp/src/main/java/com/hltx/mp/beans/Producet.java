package com.hltx.mp.beans;

import java.math.BigDecimal;
import java.util.Date;

public class Producet {
    private String proId;

    private String proName;

    private BigDecimal proPrice;

    private Integer proNumber;

    private Date proAddtime;

    private String proAdduser;

    private BigDecimal proCommission1;

    private BigDecimal proCommission2;

    private BigDecimal proCommission3;

    private Integer proIntegral;

    private Integer proIntegral2;

    private Integer proIntegral3;

    private Integer proStatus;

    private Integer proRecommended;

    private String proImg;

    private String proThumbnail;

    private String proDescribe;

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName == null ? null : proName.trim();
    }

    public BigDecimal getProPrice() {
        return proPrice;
    }

    public void setProPrice(BigDecimal proPrice) {
        this.proPrice = proPrice;
    }

    public Integer getProNumber() {
        return proNumber;
    }

    public void setProNumber(Integer proNumber) {
        this.proNumber = proNumber;
    }

    public Date getProAddtime() {
        return proAddtime;
    }

    public void setProAddtime(Date proAddtime) {
        this.proAddtime = proAddtime;
    }

    public String getProAdduser() {
        return proAdduser;
    }

    public void setProAdduser(String proAdduser) {
        this.proAdduser = proAdduser == null ? null : proAdduser.trim();
    }

    public BigDecimal getProCommission1() {
        return proCommission1;
    }

    public void setProCommission1(BigDecimal proCommission1) {
        this.proCommission1 = proCommission1;
    }

    public BigDecimal getProCommission2() {
        return proCommission2;
    }

    public void setProCommission2(BigDecimal proCommission2) {
        this.proCommission2 = proCommission2;
    }

    public BigDecimal getProCommission3() {
        return proCommission3;
    }

    public void setProCommission3(BigDecimal proCommission3) {
        this.proCommission3 = proCommission3;
    }

    public Integer getProIntegral() {
        return proIntegral;
    }

    public void setProIntegral(Integer proIntegral) {
        this.proIntegral = proIntegral;
    }

    public Integer getProIntegral2() {
        return proIntegral2;
    }

    public void setProIntegral2(Integer proIntegral2) {
        this.proIntegral2 = proIntegral2;
    }

    public Integer getProIntegral3() {
        return proIntegral3;
    }

    public void setProIntegral3(Integer proIntegral3) {
        this.proIntegral3 = proIntegral3;
    }

    public Integer getProStatus() {
        return proStatus;
    }

    public void setProStatus(Integer proStatus) {
        this.proStatus = proStatus;
    }

    public Integer getProRecommended() {
        return proRecommended;
    }

    public void setProRecommended(Integer proRecommended) {
        this.proRecommended = proRecommended;
    }

    public String getProImg() {
        return proImg;
    }

    public void setProImg(String proImg) {
        this.proImg = proImg == null ? null : proImg.trim();
    }

    public String getProThumbnail() {
        return proThumbnail;
    }

    public void setProThumbnail(String proThumbnail) {
        this.proThumbnail = proThumbnail == null ? null : proThumbnail.trim();
    }

    public String getProDescribe() {
        return proDescribe;
    }

    public void setProDescribe(String proDescribe) {
        this.proDescribe = proDescribe == null ? null : proDescribe.trim();
    }
}