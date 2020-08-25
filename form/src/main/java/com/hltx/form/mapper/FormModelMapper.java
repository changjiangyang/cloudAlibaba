package com.hltx.form.mapper;

import com.hltx.beans.FormModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FormModelMapper {

    List<Map> getModelByCompany(@Param("id") String id, @Param("index") Integer index,
                                @Param("pagesize") Integer pagesize,@Param("key") String key);

    int deleteModel(String id);

    int addModel(@Param("formModel") FormModel formModel);

    int getCountByCompany(@Param("id") String id,@Param("key") String key);

    int updateModel(@Param("id") String id,@Param("name") String name ,@Param("columns") String columns);

    Map getModelByid(@Param("id") String id);
}
