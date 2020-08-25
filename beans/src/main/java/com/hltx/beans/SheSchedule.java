package com.hltx.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * User: ycj
 * Date: 2020/8/7
 * Time: 11:38
 * Description:
 */
public class SheSchedule implements Serializable {
    private Long id ;
    /** 用户id;用户编号 */
    private String userid ;
    /** 提醒方式;提醒方式 */
    private Integer remindtype ;
    /** 提醒时间;提醒用户的时间 */
    private Date time ;
    /** 创建时间;添加时间 */
    private Date createtime ;
    /** 日程状态;1已过期0正常2用户设置不在提醒 */
    private String stauts ;
    /** 结束时间;日程结束时间 */
    private Date endtime ;
    /** 提醒内容;内容100字以内 */
    private String text ;

    /**  */
    public Long getId(){
        return this.id;
    }
    /**  */
    public void setId(Long id){
        this.id = id;
    }
    /** 用户id;用户编号 */
    public String getUserid(){
        return this.userid;
    }
    /** 用户id;用户编号 */
    public void setUserid(String userid){
        this.userid = userid;
    }
    /** 提醒方式;提醒方式 */
    public Integer getRemindtype(){
        return this.remindtype;
    }
    /** 提醒方式;提醒方式 */
    public void setRemindtype(Integer remindtype){
        this.remindtype = remindtype;
    }
    /** 提醒时间;提醒用户的时间 */
    public Date getTime(){
        return this.time;
    }
    /** 提醒时间;提醒用户的时间 */
    public void setTime(Date time){
        this.time = time;
    }
    /** 创建时间;添加时间 */
    public Date getCreatetime(){
        return this.createtime;
    }
    /** 创建时间;添加时间 */
    public void setCreatetime(Date createtime){
        this.createtime = createtime;
    }
    /** 日程状态;1已过期0正常2用户设置不在提醒 */
    public String getStauts(){
        return this.stauts;
    }
    /** 日程状态;1已过期0正常2用户设置不在提醒 */
    public void setStauts(String stauts){
        this.stauts = stauts;
    }
    /** 结束时间;日程结束时间 */
    public Date getEndtime(){
        return this.endtime;
    }
    /** 结束时间;日程结束时间 */
    public void setEndtime(Date endtime){
        this.endtime = endtime;
    }
    /** 提醒内容;内容100字以内 */
    public String getText(){
        return this.text;
    }
    /** 提醒内容;内容100字以内 */
    public void setText(String text){
        this.text = text;
    }
}
