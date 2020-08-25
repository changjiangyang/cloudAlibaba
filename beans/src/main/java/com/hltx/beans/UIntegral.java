package com.hltx.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * User: ycj
 * Date: 2020/8/7
 * Time: 11:30
 * Description:
 */
public class UIntegral implements Serializable {

    private String id ;
    /** 用户id;用户id */
    private String userid ;
    /** 积分;积分 */
    private Integer integral ;
    /** 添加时间;添加积分时间 */
    private Date addtime ;
    /** 来源;积分来源 */
    private String source ;

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
    /** 积分;积分 */
    public Integer getIntegral(){
        return this.integral;
    }
    /** 积分;积分 */
    public void setIntegral(Integer integral){
        this.integral = integral;
    }
    /** 添加时间;添加积分时间 */
    public Date getAddtime(){
        return this.addtime;
    }
    /** 添加时间;添加积分时间 */
    public void setAddtime(Date addtime){
        this.addtime = addtime;
    }
    /** 来源;积分来源 */
    public String getSource(){
        return this.source;
    }
    /** 来源;积分来源 */
    public void setSource(String source){
        this.source = source;
    }
}
