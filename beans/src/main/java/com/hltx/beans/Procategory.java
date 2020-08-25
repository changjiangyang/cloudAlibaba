package com.hltx.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * User: ycj
 * Date: 2020/8/7
 * Time: 11:36
 * Description:
 */
public class Procategory implements Serializable {
    private String id ;
    /** 类别名称;类别名称 */
    private String name ;
    /** 创建时间;分类创建时间 */
    private Date addtime ;
    /** 上级编号;上级编号 */
    private String superiorid ;
    /** 排序;数字越大越靠前最大999 */
    private Integer sort ;

    /**  */
    public String getId(){
        return this.id;
    }
    /**  */
    public void setId(String id){
        this.id = id;
    }
    /** 类别名称;类别名称 */
    public String getName(){
        return this.name;
    }
    /** 类别名称;类别名称 */
    public void setName(String name){
        this.name = name;
    }
    /** 创建时间;分类创建时间 */
    public Date getAddtime(){
        return this.addtime;
    }
    /** 创建时间;分类创建时间 */
    public void setAddtime(Date addtime){
        this.addtime = addtime;
    }
    /** 上级编号;上级编号 */
    public String getSuperiorid(){
        return this.superiorid;
    }
    /** 上级编号;上级编号 */
    public void setSuperiorid(String superiorid){
        this.superiorid = superiorid;
    }
    /** 排序;数字越大越靠前最大999 */
    public Integer getSort(){
        return this.sort;
    }
    /** 排序;数字越大越靠前最大999 */
    public void setSort(Integer sort){
        this.sort = sort;
    }
}
