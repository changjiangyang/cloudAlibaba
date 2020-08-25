package com.hltx.beans;

import java.io.Serializable;

/**
 * User: ycj
 * Date: 2020/8/7
 * Time: 11:42
 * Description:
 */
public class ComStation implements Serializable {

    private Integer id ;
    /** 岗位名 */
    private String name ;
    /** 部门id */
    private Integer departmentid ;
    /** 企业id */
    private Integer companyid ;

    /**  */
    public Integer getId(){
        return this.id;
    }
    /**  */
    public void setId(Integer id){
        this.id = id;
    }
    /** 岗位名 */
    public String getName(){
        return this.name;
    }
    /** 岗位名 */
    public void setName(String name){
        this.name = name;
    }
    /** 部门id */
    public Integer getDepartmentid(){
        return this.departmentid;
    }
    /** 部门id */
    public void setDepartmentid(Integer departmentid){
        this.departmentid = departmentid;
    }
    /** 企业id */
    public Integer getCompanyid(){
        return this.companyid;
    }
    /** 企业id */
    public void setCompanyid(Integer companyid){
        this.companyid = companyid;
    }
}
