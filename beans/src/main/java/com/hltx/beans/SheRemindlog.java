package com.hltx.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * User: ycj
 * Date: 2020/8/7
 * Time: 11:39
 * Description:
 */
public class SheRemindlog implements Serializable {
    private Integer id ;
    /** 日程id;日程id */
    private Integer sid ;
    /** 提醒时间;操作时间 */
    private Date remindtimte ;
    /** 用户id;用户id */
    private String userid ;
    /** 提醒内容;提醒用户的内容 */
    private String text ;
    /** 提醒状态;发送消息是否成功 */
    private String stauts ;
    /** 操作类型;1发送用户消息2用户推迟提醒时间 */
    private String type ;

    /**  */
    public Integer getId(){
        return this.id;
    }
    /**  */
    public void setId(Integer id){
        this.id = id;
    }
    /** 日程id;日程id */
    public Integer getSid(){
        return this.sid;
    }
    /** 日程id;日程id */
    public void setSid(Integer sid){
        this.sid = sid;
    }
    /** 提醒时间;操作时间 */
    public Date getRemindtimte(){
        return this.remindtimte;
    }
    /** 提醒时间;操作时间 */
    public void setRemindtimte(Date remindtimte){
        this.remindtimte = remindtimte;
    }
    /** 用户id;用户id */
    public String getUserid(){
        return this.userid;
    }
    /** 用户id;用户id */
    public void setUserid(String userid){
        this.userid = userid;
    }
    /** 提醒内容;提醒用户的内容 */
    public String getText(){
        return this.text;
    }
    /** 提醒内容;提醒用户的内容 */
    public void setText(String text){
        this.text = text;
    }
    /** 提醒状态;发送消息是否成功 */
    public String getStauts(){
        return this.stauts;
    }
    /** 提醒状态;发送消息是否成功 */
    public void setStauts(String stauts){
        this.stauts = stauts;
    }
    /** 操作类型;1发送用户消息2用户推迟提醒时间 */
    public String getType(){
        return this.type;
    }
    /** 操作类型;1发送用户消息2用户推迟提醒时间 */
    public void setType(String type){
        this.type = type;
    }
}
