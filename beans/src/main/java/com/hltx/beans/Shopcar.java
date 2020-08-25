package com.hltx.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * User: ycj
 * Date: 2020/8/7
 * Time: 11:35
 * Description:
 */
public class Shopcar implements Serializable {

    private String id ;
    /** 用户id;用户id */
    private String userid ;
    /** 用户名;用户名 */
    private String username ;
    /** 创建时间;创建时间 */
    private Date cteatetime ;
    /** 总金额;购物车总金额 */
    private Double money ;
    /** 状态;购物车状态0,未付款1已付款 */
    private String stauts ;
    /** 支付金额;应付金额 */
    private Double paymoney ;
    /** 折扣金额;所有商品的折扣总金额 */
    private Double discountmoney ;
    /** 支付积分;所有商品的应付积分 */
    private Integer payintegral ;

    /**  */
    public String getId(){
        return this.id;
    }
    /**  */
    public void setId(String id){
        this.id = id;
    }
    /** 用户id;用户id */
    public String getUserid(){
        return this.userid;
    }
    /** 用户id;用户id */
    public void setUserid(String userid){
        this.userid = userid;
    }
    /** 用户名;用户名 */
    public String getUsername(){
        return this.username;
    }
    /** 用户名;用户名 */
    public void setUsername(String username){
        this.username = username;
    }
    /** 创建时间;创建时间 */
    public Date getCteatetime(){
        return this.cteatetime;
    }
    /** 创建时间;创建时间 */
    public void setCteatetime(Date cteatetime){
        this.cteatetime = cteatetime;
    }
    /** 总金额;购物车总金额 */
    public Double getMoney(){
        return this.money;
    }
    /** 总金额;购物车总金额 */
    public void setMoney(Double money){
        this.money = money;
    }
    /** 状态;购物车状态0,未付款1已付款 */
    public String getStauts(){
        return this.stauts;
    }
    /** 状态;购物车状态0,未付款1已付款 */
    public void setStauts(String stauts){
        this.stauts = stauts;
    }
    /** 支付金额;应付金额 */
    public Double getPaymoney(){
        return this.paymoney;
    }
    /** 支付金额;应付金额 */
    public void setPaymoney(Double paymoney){
        this.paymoney = paymoney;
    }
    /** 折扣金额;所有商品的折扣总金额 */
    public Double getDiscountmoney(){
        return this.discountmoney;
    }
    /** 折扣金额;所有商品的折扣总金额 */
    public void setDiscountmoney(Double discountmoney){
        this.discountmoney = discountmoney;
    }
    /** 支付积分;所有商品的应付积分 */
    public Integer getPayintegral(){
        return this.payintegral;
    }
    /** 支付积分;所有商品的应付积分 */
    public void setPayintegral(Integer payintegral){
        this.payintegral = payintegral;
    }
}
