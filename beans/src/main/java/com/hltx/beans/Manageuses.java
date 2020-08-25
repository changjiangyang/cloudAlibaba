package com.hltx.beans;

import java.util.Date;

/**
 * User: ycj
 * Date: 2020/8/7
 * Time: 11:34
 * Description:
 */
public class Manageuses {

    /**  */
    private String id ;
    /** 用户名 */
    private String username ;
    /** 登录名 */
    private String loginname ;
    /** 登录密码 */
    private String pwd ;
    /** 添加时间 */
    private Date createtime ;

    /**  */
    public String getId(){
        return this.id;
    }
    /**  */
    public void setId(String id){
        this.id = id;
    }
    /** 用户名 */
    public String getUsername(){
        return this.username;
    }
    /** 用户名 */
    public void setUsername(String username){
        this.username = username;
    }
    /** 登录名 */
    public String getLoginname(){
        return this.loginname;
    }
    /** 登录名 */
    public void setLoginname(String loginname){
        this.loginname = loginname;
    }
    /** 登录密码 */
    public String getPwd(){
        return this.pwd;
    }
    /** 登录密码 */
    public void setPwd(String pwd){
        this.pwd = pwd;
    }
    /** 添加时间 */
    public Date getCreatetime(){
        return this.createtime;
    }
    /** 添加时间 */
    public void setCreatetime(Date createtime){
        this.createtime = createtime;
    }
}
