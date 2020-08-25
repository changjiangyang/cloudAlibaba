package com.hltx.form.mapper;

import com.hltx.beans.FormPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FormPageMapper {

    int insertFormPage(@Param("formPage") FormPage formPage);

    int deleteFormPage(String id);

    int updateFormStatus(FormPage formPage);

    FormPage getByid(String id);

    List<FormPage> getByPage(@Param("key") String key,@Param("index")Integer index,@Param("pagesize")Integer pagesize,@Param("companyid")Integer companyid);

    int getCount(@Param("key")String key,@Param("companyid")Integer companyid);

    List<FormPage> getByCompany(String key ,Integer company);

    int fabu(String id);
}
