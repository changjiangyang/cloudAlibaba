package com.hltx.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * User: ycj
 * Date: 2020/8/7
 * Time: 11:43
 * Description:
 */
public class FormValue implements Serializable {
    private String id ;
    /** 填写人 */
    private Integer filluserid ;
    private String filusername;
    /** 填写时间 */
    private Date filltime ;
    /** 填写内容 */
    private String fillcontent ;

    private String modelid;

    private String fillphone;

    public String getFillphone() {
        return fillphone;
    }

    public void setFillphone(String fillphone) {
        this.fillphone = fillphone;
    }

    public String getFilusername() {
        return filusername;
    }

    public void setFilusername(String filusername) {
        this.filusername = filusername;
    }

    public String getModelid() {
        return modelid;
    }

    public void setModelid(String modelid) {
        this.modelid = modelid;
    }

    /**  */
    public String getId(){
        return this.id;
    }
    /**  */
    public void setId(String id){
        this.id = id;
    }
    /** 填写人 */
    public Integer getFilluserid(){
        return this.filluserid;
    }
    /** 填写人 */
    public void setFilluserid(Integer filluserid){
        this.filluserid = filluserid;
    }
    /** 填写时间 */
    public Date getFilltime(){
        return this.filltime;
    }
    /** 填写时间 */
    public void setFilltime(Date filltime){
        this.filltime = filltime;
    }
    /** 填写内容 */
    public String getFillcontent(){
        return this.fillcontent;
    }
    /** 填写内容 */
    public void setFillcontent(String fillcontent){
        this.fillcontent = fillcontent;
    }
}
