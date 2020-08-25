package com.hltx.form.service;

import com.hltx.beans.FormModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * User: ycj
 * Date: 2020/8/12
 * Time: 16:13
 * Description:
 */
public interface FormModelServer {

    List<Map> getModelByCompany(String id, Integer index, Integer pagesize,String key);

    int deleteModel(String id);

    int addModel(@Param("formModel") FormModel formModel);

    int getCountByCompany(String id,String key);

    int updateModel(String id,String name ,String columns);
    Map getModelByid(@Param("id") String id);
}
