package com.hltx.form.service.impl;

import com.hltx.beans.FormModel;
import com.hltx.form.mapper.FormModelMapper;
import com.hltx.form.service.FormModelServer;
import com.hltx.form.util.RedisUtils;
import com.hltx.tool.BackCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * User: ycj
 * Date: 2020/8/12
 * Time: 16:14
 * Description:
 */
@Service("formModelServer")
public class FormModelServerImpl implements FormModelServer {

    @Autowired
    FormModelMapper formModelMapper;
    @Autowired
    RedisUtils redisUtils;

    @Override
    public List<Map> getModelByCompany(String id, Integer index, Integer pagesize,String key) {
        return formModelMapper.getModelByCompany(id, index, pagesize,key);
    }

    @Override
    public int deleteModel(String id) {
        return formModelMapper.deleteModel(id);
    }

    @Override
    public int addModel(FormModel formModel) {
        return formModelMapper.addModel(formModel);
    }

    @Override
    public int getCountByCompany(String id,String key) {
        return formModelMapper.getCountByCompany(id,key);
    }

    @Override
    public int updateModel(String id,String name, String columns) {
        return formModelMapper.updateModel(id,name, columns);
    }

    @Override
    public Map getModelByid(String id) {
        String key="formmodel"+id;
        if (redisUtils.get(key)!= null){
            return (Map) redisUtils.get(key);
        }else{
            Map map=formModelMapper.getModelByid(id);
            redisUtils.set(key,map);
            return map;
        }
    }
}
