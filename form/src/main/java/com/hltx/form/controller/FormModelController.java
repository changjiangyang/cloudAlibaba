package com.hltx.form.controller;

import com.hltx.beans.FormModel;
import com.hltx.form.service.FormModelServer;
import com.hltx.form.util.RedisUtils;
import com.hltx.tool.BackCodeUtils;
import com.sun.istack.internal.NotNull;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * User: ycj
 * Date: 2020/8/12
 * Time: 16:16
 * Description:
 */
@RestController
@RequestMapping("formModel")
public class FormModelController {

    @Autowired
    private FormModelServer formModelServer;
    @Autowired
    private RedisUtils redisUtils;

    @GetMapping(value = "getModelByCompany")
    public Map<String,Object> getModelByCompany(String id,String keys,
                                                @RequestParam(value = "index",defaultValue = "0") Integer index,
                                                @RequestParam(value = "pagesize",defaultValue = "10") Integer pagesize){
        String key="companymodel"+id;
        if (redisUtils.get(key) != null){
            return BackCodeUtils.getSuccess(redisUtils.get(keys));
        }else{
            List<Map> list=formModelServer.getModelByCompany(id, index, pagesize,keys);
            int t=formModelServer.getCountByCompany(id,keys);
            if (list==null)
                return BackCodeUtils.getNan();
            if (list.size()>0){
                //redisUtils.set(key,list,30*60*1000);
                Map<String ,Object> map=new HashMap<>();
                map.put("code",10000);
                map.put("data",list);
                map.put("count",t);
                map.put("message","SUCCESS");
                return map;
                //return BackCodeUtils.getSuccess(list);
            }else {
                return BackCodeUtils.getNan();
            }
        }
    }

    @GetMapping(value = "deleteModel")
    public Map<String,Object> deleteModel(String id,Integer pid){
        if (pid==null)
            return BackCodeUtils.getMissParament("缺少企业id");
        if (id==null)
            return BackCodeUtils.getMissParament("缺少模板id");
        String key="companymodel"+pid;
        int t=formModelServer.deleteModel(id);

            redisUtils.del(key);
            redisUtils.del("companymodelcount"+pid);
        if (redisUtils.get("companymodelcount"+id)!= null)
            redisUtils.del("companymodelcount"+id);
        if (t>0)
            return BackCodeUtils.getSuccess("SUCCESS");
        else
            return BackCodeUtils.getFail();
    }

    @PostMapping(value = "addModel")
    public Map<String,Object> addModel(FormModel formModel){
        if (formModel.getCompanyid().equals(""))
            return BackCodeUtils.getMissParament("缺少参数企业id");
        String key = "companymodel"+ formModel.getCompanyid();
        String id= UUID.randomUUID().toString().replace("-","");
        formModel.setId(id);
        int t = formModelServer.addModel(formModel);
        List<Map> list = null;
        Map map=null;
        if (t>0){
            map=new HashMap();
            map.put("id",id);
            map.put("columns",formModel.getColumns());
            map.put("name",formModel.getName());
            map.put("createtime",new Date());
            if (redisUtils.get(key)!= null){
                list= (List<Map>) redisUtils.get(key);
            }else {
                list = new ArrayList<>();
            }
            list.add(map);
            redisUtils.del(key,"companymodelcount"+formModel.getCompanyid());
            return BackCodeUtils.getSuccess("SUCCESS");
        }else {
            return BackCodeUtils.getFail();
        }
    }

    @GetMapping(value = "getCountByCompany")
    public Map<String,Object> getCountByCompany(String id,String keys){
        String key="companymodelcount"+id;
        int t=0;
        if (redisUtils.get(key)!=null){
            t= (int) redisUtils.get(key);
            return BackCodeUtils.getSuccess(t);
        }else{
           t= formModelServer.getCountByCompany(id,keys);
           redisUtils.set(key,t,30*60*1000);
           return BackCodeUtils.getSuccess(t);
        }
    }

    @PostMapping(value = "updateModel")
    public Map<String,Object>updateModel(String columns,String name,String id,Integer pid){
        String key="companymodel"+pid;
        int t=formModelServer.updateModel(id,name,columns);
        if (t>0){
            if (redisUtils.get(key)!= null){
                redisUtils.del(key);
            }
            return BackCodeUtils.getSuccess("SUCCESS");
        }else {
            return BackCodeUtils.getFail();
        }
    }

    @RequestMapping(value = "getModelByid",method = RequestMethod.GET)
    public Map<String,Object> getModelByid(@NotNull String id){
        Map map=formModelServer.getModelByid(id);
        if (map!= null) {
            if (map.size() > 0) {
                return BackCodeUtils.getSuccess(map);
            } else {
                return BackCodeUtils.getNan();
            }
        }else{
            return BackCodeUtils.getFail();
        }
    }
}
