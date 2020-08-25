package com.hltx.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * User: ycj
 * Date: 2020/8/7
 * Time: 11:42
 * Description:
 */
public class Log implements Serializable {
    private String id ;
    /** 添加时间 */
    private Date addtime ;
    /** 操作员工 */
    private Integer adduser ;
    /** 操作状态 */
    private String status ;
    /** 操作内容 */
    private String context ;

    /**  */
    public String getId(){
        return this.id;
    }
    /**  */
    public void setId(String id){
        this.id = id;
    }
    /** 添加时间 */
    public Date getAddtime(){
        return this.addtime;
    }
    /** 添加时间 */
    public void setAddtime(Date addtime){
        this.addtime = addtime;
    }
    /** 操作员工 */
    public Integer getAdduser(){
        return this.adduser;
    }
    /** 操作员工 */
    public void setAdduser(Integer adduser){
        this.adduser = adduser;
    }
    /** 操作状态 */
    public String getStatus(){
        return this.status;
    }
    /** 操作状态 */
    public void setStatus(String status){
        this.status = status;
    }
    /** 操作内容 */
    public String getContext(){
        return this.context;
    }
    /** 操作内容 */
    public void setContext(String context){
        this.context = context;
    }
}
