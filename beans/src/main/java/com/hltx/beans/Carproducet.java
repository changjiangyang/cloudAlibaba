package com.hltx.beans;

import java.io.Serializable;

/**
 * User: ycj
 * Date: 2020/8/7
 * Time: 11:36
 * Description:
 */
public class Carproducet implements Serializable {

    private String id ;
    /** 商品id */
    private String producet ;
    /** 购物车id */
    private String carid ;
    /** 商品名称 */
    private String pname ;
    /** 购买数量 */
    private Integer num ;

    /**  */
    public String getId(){
        return this.id;
    }
    /**  */
    public void setId(String id){
        this.id = id;
    }
    /** 商品id */
    public String getProducet(){
        return this.producet;
    }
    /** 商品id */
    public void setProducet(String producet){
        this.producet = producet;
    }
    /** 购物车id */
    public String getCarid(){
        return this.carid;
    }
    /** 购物车id */
    public void setCarid(String carid){
        this.carid = carid;
    }
    /** 商品名称 */
    public String getPname(){
        return this.pname;
    }
    /** 商品名称 */
    public void setPname(String pname){
        this.pname = pname;
    }
    /** 购买数量 */
    public Integer getNum(){
        return this.num;
    }
    /** 购买数量 */
    public void setNum(Integer num){
        this.num = num;
    }
}
