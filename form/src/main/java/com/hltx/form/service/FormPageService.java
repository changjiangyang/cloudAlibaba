package com.hltx.form.service;

import com.hltx.beans.FormPage;

import java.util.List;

public interface FormPageService {

    int insertFormPage(FormPage formPage);

    int deleteFormPage(String id);

    int updateFormStatus(FormPage formPage);

    FormPage getByid(String id);

    List<FormPage> getByPage(String key, Integer index, Integer pagesize, Integer companyid);

    int getCount(String key,Integer companyid);

    List<FormPage> getByCompany(String key ,Integer company);


    int fabu(String id);
}
