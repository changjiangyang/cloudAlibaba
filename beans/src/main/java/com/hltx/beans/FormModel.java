package com.hltx.beans;

import java.sql.Timestamp;
import java.util.Date;

/**
 * User: ycj
 * Date: 2020/8/7
 * Time: 11:43
 * Description:
 */
public class FormModel {

    private String id ;
    /** 模板名 */
    private String name ;
    /** 创建时间 */
    private Timestamp createtime ;
    /** 创建人编号 */
    private String createuser ;
    /** 模板属性 */
    private String columns ;
    /** 企业id */
    private Integer companyid ;
    /** 部门id */
    private Integer deartmentid ;

    private Date updatetime;

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**  */
    public String getId(){
        return this.id;
    }
    /**  */
    public void setId(String id){
        this.id = id;
    }
    /** 模板名 */
    public String getName(){
        return this.name;
    }
    /** 模板名 */
    public void setName(String name){
        this.name = name;
    }
    /** 创建时间 */
    public Timestamp getCreatetime(){
        return this.createtime;
    }
    /** 创建时间 */
    public void setCreatetime(Timestamp createtime){
        this.createtime = createtime;
    }
    /** 创建人编号 */
    public String getCreateuser(){
        return this.createuser;
    }
    /** 创建人编号 */
    public void setCreateuser(String createuser){
        this.createuser = createuser;
    }
    /** 模板属性 */
    public String getColumns(){
        return this.columns;
    }
    /** 模板属性 */
    public void setColumns(String columns){
        this.columns = columns;
    }
    /** 企业id */
    public Integer getCompanyid(){
        return this.companyid;
    }
    /** 企业id */
    public void setCompanyid(Integer companyid){
        this.companyid = companyid;
    }
    /** 部门id */
    public Integer getDeartmentid(){
        return this.deartmentid;
    }
    /** 部门id */
    public void setDeartmentid(Integer deartmentid){
        this.deartmentid = deartmentid;
    }
}
