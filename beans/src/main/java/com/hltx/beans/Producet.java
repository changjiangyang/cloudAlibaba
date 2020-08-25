package com.hltx.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * User: ycj
 * Date: 2020/8/7
 * Time: 11:37
 * Description:
 */
public class Producet implements Serializable {
    private String id ;
    /** 商品名;商品名 */
    private String name ;
    /** 创建时间;添加时间 */
    private Date addtime ;
    /** 金额;原价 */
    private String money ;
    /** 折扣金额;打完折后计算出的金额 */
    private Double discountmoney ;
    /** 折扣;折扣额 */
    private String discount ;
    /** 一级分类;商品的一级分类 */
    private String firsttype ;
    /** 二级分类;二级分类 */
    private String secondtype ;
    /** 三级分类;三级分类 */
    private String thirdtype ;
    /** 商品状态;0上架1下架 */
    private String stauts ;
    /** 库存;商品库存数量 */
    private Integer stock ;
    /** 支付积分;购买商品需要支付的积分 */
    private Integer payintegral ;
    /** 积分;购买商品获得的积分 */
    private Integer integral ;
    /** 付款方式;0现金1积分2现金加积分 */
    private Integer paymethod ;
    /** 商品缩略图;商品缩略图，用于首页展示 */
    private String img ;

    /** 商品id */
    public String getId(){
        return this.id;
    }
    /** 商品id */
    public void setId(String id){
        this.id = id;
    }
    /** 商品名;商品名 */
    public String getName(){
        return this.name;
    }
    /** 商品名;商品名 */
    public void setName(String name){
        this.name = name;
    }
    /** 创建时间;添加时间 */
    public Date getAddtime(){
        return this.addtime;
    }
    /** 创建时间;添加时间 */
    public void setAddtime(Date addtime){
        this.addtime = addtime;
    }
    /** 金额;原价 */
    public String getMoney(){
        return this.money;
    }
    /** 金额;原价 */
    public void setMoney(String money){
        this.money = money;
    }
    /** 折扣金额;打完折后计算出的金额 */
    public Double getDiscountmoney(){
        return this.discountmoney;
    }
    /** 折扣金额;打完折后计算出的金额 */
    public void setDiscountmoney(Double discountmoney){
        this.discountmoney = discountmoney;
    }
    /** 折扣;折扣额 */
    public String getDiscount(){
        return this.discount;
    }
    /** 折扣;折扣额 */
    public void setDiscount(String discount){
        this.discount = discount;
    }
    /** 一级分类;商品的一级分类 */
    public String getFirsttype(){
        return this.firsttype;
    }
    /** 一级分类;商品的一级分类 */
    public void setFirsttype(String firsttype){
        this.firsttype = firsttype;
    }
    /** 二级分类;二级分类 */
    public String getSecondtype(){
        return this.secondtype;
    }
    /** 二级分类;二级分类 */
    public void setSecondtype(String secondtype){
        this.secondtype = secondtype;
    }
    /** 三级分类;三级分类 */
    public String getThirdtype(){
        return this.thirdtype;
    }
    /** 三级分类;三级分类 */
    public void setThirdtype(String thirdtype){
        this.thirdtype = thirdtype;
    }
    /** 商品状态;0上架1下架 */
    public String getStauts(){
        return this.stauts;
    }
    /** 商品状态;0上架1下架 */
    public void setStauts(String stauts){
        this.stauts = stauts;
    }
    /** 库存;商品库存数量 */
    public Integer getStock(){
        return this.stock;
    }
    /** 库存;商品库存数量 */
    public void setStock(Integer stock){
        this.stock = stock;
    }
    /** 支付积分;购买商品需要支付的积分 */
    public Integer getPayintegral(){
        return this.payintegral;
    }
    /** 支付积分;购买商品需要支付的积分 */
    public void setPayintegral(Integer payintegral){
        this.payintegral = payintegral;
    }
    /** 积分;购买商品获得的积分 */
    public Integer getIntegral(){
        return this.integral;
    }
    /** 积分;购买商品获得的积分 */
    public void setIntegral(Integer integral){
        this.integral = integral;
    }
    /** 付款方式;0现金1积分2现金加积分 */
    public Integer getPaymethod(){
        return this.paymethod;
    }
    /** 付款方式;0现金1积分2现金加积分 */
    public void setPaymethod(Integer paymethod){
        this.paymethod = paymethod;
    }
    /** 商品缩略图;商品缩略图，用于首页展示 */
    public String getImg(){
        return this.img;
    }
    /** 商品缩略图;商品缩略图，用于首页展示 */
    public void setImg(String img){
        this.img = img;
    }
}
