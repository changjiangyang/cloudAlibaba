package com.hltx.beans;

import java.io.Serializable;

/**
 * User: ycj
 * Date: 2020/8/7
 * Time: 11:39
 * Description:
 */
public class SheRemindmethod implements Serializable {

    private Integer id ;
    /** 提醒方式 */
    private String name ;

    /**  */
    public Integer getId(){
        return this.id;
    }
    /**  */
    public void setId(Integer id){
        this.id = id;
    }
    /** 提醒方式 */
    public String getName(){
        return this.name;
    }
    /** 提醒方式 */
    public void setName(String name){
        this.name = name;
    }
}
