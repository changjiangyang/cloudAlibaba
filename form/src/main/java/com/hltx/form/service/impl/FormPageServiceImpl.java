package com.hltx.form.service.impl;

import com.hltx.beans.FormPage;
import com.hltx.form.mapper.FormPageMapper;
import com.hltx.form.service.FormPageService;
import com.hltx.form.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("formPageService")
public class FormPageServiceImpl implements FormPageService {

    @Autowired
    FormPageMapper formPageMapper;
    @Autowired
    RedisUtils redisUtils;

    @Override
    public int insertFormPage(FormPage formPage) {
        return formPageMapper.insertFormPage(formPage);
    }

    @Override
    public int deleteFormPage(String id) {
        int t = formPageMapper.deleteFormPage(id);
        String key= "formpage"+id;
        if ( t >0 ){
            if (redisUtils.get(key)!=null){
                redisUtils.del(key);
            }
        }
        return t;
    }

    @Override
    public int updateFormStatus(FormPage formPage) {
        int t= formPageMapper.updateFormStatus(formPage);
        if (t>0){
            //redisUtils.set("formpage"+formPage.getId(),formPage);
            return t;
        }
        return 0;
    }

    @Override
    public FormPage getByid(String id) {
        String key= "formpage"+id;
        if (redisUtils.get(key)==null){
            FormPage formPage= formPageMapper.getByid(id);
            redisUtils.set(key,formPage);
            return formPage;
        }else
            return (FormPage) redisUtils.get(key);
    }

    @Override
    public List<FormPage> getByPage(String key, Integer index, Integer pagesize, Integer companyid) {
        return formPageMapper.getByPage(key, index, pagesize, companyid);
    }

    @Override
    public int getCount(String key, Integer companyid) {
        return formPageMapper.getCount(key, companyid);
    }

    @Override
    public List<FormPage> getByCompany(String key, Integer company) {
        return formPageMapper.getByCompany(key, company);
    }

    @Override
    public int fabu(String id) {
        String key= "formpage"+id;
        FormPage formPage=null;
        int t =  formPageMapper.fabu(id);
        if (t > 0){
            if (redisUtils.get(key) != null){
                formPage= (FormPage) redisUtils.get(key);
                formPage.setStatus(2);
                redisUtils.set(key,formPage);
            }
            return t;
        }
        return 0;
    }
}
