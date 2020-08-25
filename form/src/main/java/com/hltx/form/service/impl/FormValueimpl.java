package com.hltx.form.service.impl;

import com.hltx.beans.FormValue;
import com.hltx.form.mapper.FormValueMapper;
import com.hltx.form.service.FormValueService;
import com.hltx.form.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: ycj
 * Date: 2020/8/13
 * Time: 14:19
 * Description:
 */
@Service("formValue")
public class FormValueimpl implements FormValueService {

    @Autowired
    private FormValueMapper formValueMapper;
    @Autowired
    RedisUtils redisUtils;

    @Override
    public int addvalue(FormValue formValue) {
        int t = formValueMapper.addvalue(formValue);
        String key="formvalue"+formValue.getId();
        if (redisUtils.get(key)!= null)
            redisUtils.del(key);
        else
            redisUtils.set(key,formValue);
        return t;
    }

    @Override
    public List<FormValue> getFormvalueBymodelID(String mid, Integer index, Integer pagesize) {
        return formValueMapper.getFormvalueBymodelID(mid, index, pagesize);
    }

    @Override
    public List<FormValue> getFormvalueByuserID(Integer uid, Integer index, Integer pagesize) {
        return formValueMapper.getFormvalueByuserID(uid, index, pagesize);
    }

    @Override
    public FormValue getByid(String id) {
        String key="formvalue"+id;
        if (redisUtils.get(key)!=null){
            return (FormValue) redisUtils.get(key);
        }
        FormValue formValue=formValueMapper.getByid(id);
        if (formValue != null){
           redisUtils.set(key,formValue);
        }else {
            return null;
        }
        return formValueMapper.getByid(id);
    }

    @Override
    public int getCountByPhoneAndMoel(String phone, String mid) {
        return formValueMapper.getCountByPhoneAndMoel(phone, mid);
    }
}
