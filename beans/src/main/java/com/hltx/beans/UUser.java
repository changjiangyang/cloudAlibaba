package com.hltx.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * User: ycj
 * Date: 2020/8/7
 * Time: 11:32
 * Description:
 */
public class UUser implements Serializable {

    private Integer id ;
    /** 姓名;姓名 */
    private String name ;
    /** 性别;性别 */
    private String sex ;
    /** 电话;电话 */
    private String phone ;
    /** 邮箱地址;邮箱地址 */
    private String email ;
    /** 更新时间;更新时间 */
    private Date createtime ;
    /** 住址;住址 */
    private String address ;
    /** uid;微信uid */
    private String uid ;
    /** openid;微信openid */
    private String openid ;
    /** 昵称;微信昵称 */
    private String nickname ;
    /** 一级推荐人;一级推荐人 */
    private Integer superid1 ;
    /** 二级推荐人;二级推荐人 */
    private Integer superid2 ;
    /** 三级推荐人;三级推荐人 */
    private Integer superid3 ;
    /** 推荐二维码;推荐二维码 */
    private Integer qrcode ;
    /** 用户类型;用户类型 */
    private Integer usertype ;
    /** 用户头像地址;用户头像地址 */
    private String handimg ;
    /** 用户名;用户名 */
    private String username ;
    /** 密码;密码 */
    private String password ;
    /** 是否删除;是否删除 */
    private String isshow ;
    /** 剩余积分;用户现有积分 */
    private Integer integral ;

    /**  */
    public Integer getId(){
        return this.id;
    }
    /**  */
    public void setId(Integer id){
        this.id = id;
    }
    /** 姓名;姓名 */
    public String getName(){
        return this.name;
    }
    /** 姓名;姓名 */
    public void setName(String name){
        this.name = name;
    }
    /** 性别;性别 */
    public String getSex(){
        return this.sex;
    }
    /** 性别;性别 */
    public void setSex(String sex){
        this.sex = sex;
    }
    /** 电话;电话 */
    public String getPhone(){
        return this.phone;
    }
    /** 电话;电话 */
    public void setPhone(String phone){
        this.phone = phone;
    }
    /** 邮箱地址;邮箱地址 */
    public String getEmail(){
        return this.email;
    }
    /** 邮箱地址;邮箱地址 */
    public void setEmail(String email){
        this.email = email;
    }
    /** 更新时间;更新时间 */
    public Date getCreatetime(){
        return this.createtime;
    }
    /** 更新时间;更新时间 */
    public void setCreatetime(Date createtime){
        this.createtime = createtime;
    }
    /** 住址;住址 */
    public String getAddress(){
        return this.address;
    }
    /** 住址;住址 */
    public void setAddress(String address){
        this.address = address;
    }
    /** uid;微信uid */
    public String getUid(){
        return this.uid;
    }
    /** uid;微信uid */
    public void setUid(String uid){
        this.uid = uid;
    }
    /** openid;微信openid */
    public String getOpenid(){
        return this.openid;
    }
    /** openid;微信openid */
    public void setOpenid(String openid){
        this.openid = openid;
    }
    /** 昵称;微信昵称 */
    public String getNickname(){
        return this.nickname;
    }
    /** 昵称;微信昵称 */
    public void setNickname(String nickname){
        this.nickname = nickname;
    }
    /** 一级推荐人;一级推荐人 */
    public Integer getSuperid1(){
        return this.superid1;
    }
    /** 一级推荐人;一级推荐人 */
    public void setSuperid1(Integer superid1){
        this.superid1 = superid1;
    }
    /** 二级推荐人;二级推荐人 */
    public Integer getSuperid2(){
        return this.superid2;
    }
    /** 二级推荐人;二级推荐人 */
    public void setSuperid2(Integer superid2){
        this.superid2 = superid2;
    }
    /** 三级推荐人;三级推荐人 */
    public Integer getSuperid3(){
        return this.superid3;
    }
    /** 三级推荐人;三级推荐人 */
    public void setSuperid3(Integer superid3){
        this.superid3 = superid3;
    }
    /** 推荐二维码;推荐二维码 */
    public Integer getQrcode(){
        return this.qrcode;
    }
    /** 推荐二维码;推荐二维码 */
    public void setQrcode(Integer qrcode){
        this.qrcode = qrcode;
    }
    /** 用户类型;用户类型 */
    public Integer getUsertype(){
        return this.usertype;
    }
    /** 用户类型;用户类型 */
    public void setUsertype(Integer usertype){
        this.usertype = usertype;
    }
    /** 用户头像地址;用户头像地址 */
    public String getHandimg(){
        return this.handimg;
    }
    /** 用户头像地址;用户头像地址 */
    public void setHandimg(String handimg){
        this.handimg = handimg;
    }
    /** 用户名;用户名 */
    public String getUsername(){
        return this.username;
    }
    /** 用户名;用户名 */
    public void setUsername(String username){
        this.username = username;
    }
    /** 密码;密码 */
    public String getPassword(){
        return this.password;
    }
    /** 密码;密码 */
    public void setPassword(String password){
        this.password = password;
    }
    /** 是否删除;是否删除 */
    public String getIsshow(){
        return this.isshow;
    }
    /** 是否删除;是否删除 */
    public void setIsshow(String isshow){
        this.isshow = isshow;
    }
    /** 剩余积分;用户现有积分 */
    public Integer getIntegral(){
        return this.integral;
    }
    /** 剩余积分;用户现有积分 */
    public void setIntegral(Integer integral){
        this.integral = integral;
    }
}
