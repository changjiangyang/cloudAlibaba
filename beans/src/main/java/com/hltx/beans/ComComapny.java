package com.hltx.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * User: ycj
 * Date: 2020/8/7
 * Time: 11:40
 * Description:
 */
public class ComComapny implements Serializable {
    private Integer id ;
    /** 企业名 */
    private String cname ;
    /** 添加时间 */
    private Date addtime ;
    /** 注册时间 */
    private Date registertime ;
    /** 统一社会信用代码 */
    private String sociologyid ;
    /** 法人 */
    private String legalperson ;
    /** 法人身份证正面url地址 */
    private String legalpersonjustpath ;
    /** 法人身份证反面url地址 */
    private String legalpersonbackpath ;
    /** 法人电话 */
    private String legalpersonphone ;
    /** 法人身份证号 */
    private String legalpersonidcard ;
    /** 法人住址 */
    private String legalpersonaddress ;
    /** 企业地址 */
    private String companyaddress ;
    /** 企业电话 */
    private String companyphone ;
    /** 注册时长单位：年 */
    private Integer duration ;
    /** 注册资金 */
    private Double capital ;
    /** 企业营业执照地址 */
    private String licensepath ;
    /** 传真 */
    private String fax ;

    /**  */
    public Integer getId(){
        return this.id;
    }
    /**  */
    public void setId(Integer id){
        this.id = id;
    }
    /** 企业名 */
    public String getCname(){
        return this.cname;
    }
    /** 企业名 */
    public void setCname(String cname){
        this.cname = cname;
    }
    /** 添加时间 */
    public Date getAddtime(){
        return this.addtime;
    }
    /** 添加时间 */
    public void setAddtime(Date addtime){
        this.addtime = addtime;
    }
    /** 注册时间 */
    public Date getRegistertime(){
        return this.registertime;
    }
    /** 注册时间 */
    public void setRegistertime(Date registertime){
        this.registertime = registertime;
    }
    /** 统一社会信用代码 */
    public String getSociologyid(){
        return this.sociologyid;
    }
    /** 统一社会信用代码 */
    public void setSociologyid(String sociologyid){
        this.sociologyid = sociologyid;
    }
    /** 法人 */
    public String getLegalperson(){
        return this.legalperson;
    }
    /** 法人 */
    public void setLegalperson(String legalperson){
        this.legalperson = legalperson;
    }
    /** 法人身份证正面url地址 */
    public String getLegalpersonjustpath(){
        return this.legalpersonjustpath;
    }
    /** 法人身份证正面url地址 */
    public void setLegalpersonjustpath(String legalpersonjustpath){
        this.legalpersonjustpath = legalpersonjustpath;
    }
    /** 法人身份证反面url地址 */
    public String getLegalpersonbackpath(){
        return this.legalpersonbackpath;
    }
    /** 法人身份证反面url地址 */
    public void setLegalpersonbackpath(String legalpersonbackpath){
        this.legalpersonbackpath = legalpersonbackpath;
    }
    /** 法人电话 */
    public String getLegalpersonphone(){
        return this.legalpersonphone;
    }
    /** 法人电话 */
    public void setLegalpersonphone(String legalpersonphone){
        this.legalpersonphone = legalpersonphone;
    }
    /** 法人身份证号 */
    public String getLegalpersonidcard(){
        return this.legalpersonidcard;
    }
    /** 法人身份证号 */
    public void setLegalpersonidcard(String legalpersonidcard){
        this.legalpersonidcard = legalpersonidcard;
    }
    /** 法人住址 */
    public String getLegalpersonaddress(){
        return this.legalpersonaddress;
    }
    /** 法人住址 */
    public void setLegalpersonaddress(String legalpersonaddress){
        this.legalpersonaddress = legalpersonaddress;
    }
    /** 企业地址 */
    public String getCompanyaddress(){
        return this.companyaddress;
    }
    /** 企业地址 */
    public void setCompanyaddress(String companyaddress){
        this.companyaddress = companyaddress;
    }
    /** 企业电话 */
    public String getCompanyphone(){
        return this.companyphone;
    }
    /** 企业电话 */
    public void setCompanyphone(String companyphone){
        this.companyphone = companyphone;
    }
    /** 注册时长单位：年 */
    public Integer getDuration(){
        return this.duration;
    }
    /** 注册时长单位：年 */
    public void setDuration(Integer duration){
        this.duration = duration;
    }
    /** 注册资金 */
    public Double getCapital(){
        return this.capital;
    }
    /** 注册资金 */
    public void setCapital(Double capital){
        this.capital = capital;
    }
    /** 企业营业执照地址 */
    public String getLicensepath(){
        return this.licensepath;
    }
    /** 企业营业执照地址 */
    public void setLicensepath(String licensepath){
        this.licensepath = licensepath;
    }
    /** 传真 */
    public String getFax(){
        return this.fax;
    }
    /** 传真 */
    public void setFax(String fax){
        this.fax = fax;
    }
}
