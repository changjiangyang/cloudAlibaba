package com.hltx.form.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hltx.beans.FormModel;
import com.hltx.beans.FormValue;
import com.hltx.form.config.ShortMessageConfig;
import com.hltx.form.service.FormModelServer;
import com.hltx.form.service.FormValueService;
import com.hltx.form.util.RedisUtils;
import com.hltx.tool.*;
import com.sun.istack.internal.NotNull;
import com.sun.org.apache.xpath.internal.objects.XObject;
import okhttp3.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: ycj
 * Date: 2020/8/13
 * Time: 12:47
 * Description:
 */
@RestController
@RequestMapping(value = "formvalue")
public class FormValueController {

    @Autowired
    FormValueService formValueService;
    @Autowired
    FormModelServer formModelServer;
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    ShortMessageConfig shortMessageConfig;


    @RequestMapping(value ="addvalue",method = RequestMethod.POST)
    public Map<String ,Object> addvalue(FormValue formValue,
                                        @RequestParam(defaultValue = "",required = false) String vlicode){
        String modelid=formValue.getModelid();
        if (modelid==null)
            return BackCodeUtils.getMissParament("模板id缺失");
        if (modelid.equals(""))
            return BackCodeUtils.getMissParament("模板id缺失");
        Map formModel=formModelServer.getModelByid(modelid);
        if (formModel==null){
            return BackCodeUtils.getMissParament("此模板不存在");
        }else {
            String columns= (String) formModel.get("columns");
            JSONArray jsonArray = JSONArray.parseArray(columns);
            for (int t=0;t<jsonArray.size();t++){
                JSONObject jsonObject=jsonArray.getJSONObject(t);
                if(jsonObject.getString("submitS").equals("电话")){
                    if (jsonObject.getString("Required").equals("1")){
                        if (formValue.getId()==null)
                            return BackCodeUtils.getMissParament("缺少主键");
                        if (formValue.getId().equals(""))
                            return BackCodeUtils.getMissParament("缺少主键");
                        String code= (String) redisUtils.get("modelvalue"+formValue.getId());
                        if (code!=null){
                            if (code.equals("")||vlicode.equals("")){
                                return BackCodeUtils.getMissParament("请输入验证码");
                            }else {
                                if (!code.equals(vlicode)){
                                    return BackCodeUtils.getMissParament("验证码错误");
                                }
                                redisUtils.del("modelvalue"+formValue.getId());
                            }
                        }else {
                            return BackCodeUtils.getMissParament("请输入验证码");
                        }
                    }
                    if (jsonObject.getString("Sole").equals("1")){
                        if (formValueService.getCountByPhoneAndMoel(jsonObject.getString("phone"),jsonObject.getString("modelid"))>0){
                            return BackCodeUtils.getOtherFail("不能重复提交");
                        }
                    }
                }
            }
        }

        formValue.setId(PrimarykeyUtil.getUUID());
        formValue.setFilltime(new Date());
        int t = formValueService.addvalue(formValue);
        if (t>0)
            return BackCodeUtils.getSuccess(formValue);
        else
            return BackCodeUtils.getFail();
    }

    @RequestMapping(value = "getFormvalueBymodelID",method = RequestMethod.GET)
    public Map<String,Object> getFormvalueBymodelID(String mid,
                                                    @RequestParam(defaultValue = "0",required = false,name = "index") Integer index,
                                                    @RequestParam(defaultValue = "10",required = false,name = "pagesize") Integer pagesize ){
        List<FormValue> list=formValueService.getFormvalueBymodelID(mid, index, pagesize);
        if (list.size()>0){
            return BackCodeUtils.getSuccess(list);
        }else{
            return BackCodeUtils.getFail();
        }
    }

    @GetMapping(value = "getFormvalueByuserID")
    public Map<String,Object> getFormvalueByuserID(Integer uid,Integer index,Integer pagesize){
        List<FormValue> list=formValueService.getFormvalueByuserID(uid, index, pagesize);
        if (list.size()>0){
            return BackCodeUtils.getSuccess(list);
        }else{
            return BackCodeUtils.getFail();
        }
    }

    @GetMapping(value = "getByid")
    public Map<String,Object> getByid(String id){
        FormValue formValue=formValueService.getByid(id);
        if (formValue==null){
            return BackCodeUtils.getNan();
        }else {
            return BackCodeUtils.getSuccess(formValue);
        }
    }

    @GetMapping(value = "getVerificationCode")
    public Map<String,Object> getVerificationCode(@NotNull String phone){
        if (!UtilValidator.isMobile(phone))
            return BackCodeUtils.getParameterExcept("手机号格式错误");
        String id=PrimarykeyUtil.getUUID();
        String key="modelvalue"+id;
        String val= VerificationCode.getrandom(6);
        Map<String,String> map=new HashMap<>(7);
        map.put("action",shortMessageConfig.getAction());
        map.put("account",shortMessageConfig.getAccount());
        map.put("password",shortMessageConfig.getPassword());
        map.put("extno",shortMessageConfig.getExtno());
        map.put("rt",shortMessageConfig.getRt());
        map.put("mobile",phone);
        String text="【号令天下】您的验证码是:"+val+",该验证码主要用于您在物联卡平台实名验证,请勿轻易将您的验证码透露给别人。";
        //text.replace("*",val);
        map.put("content",text);
        String result=HttpUtils.sendPost(shortMessageConfig.getUrl(), map);
        System.out.println(result);
        JSONObject jsonObject=JSONObject.parseObject(result);
        if (jsonObject.getString("status").equals("0")){
            //发送成功
            long time = 5*(60);
            redisUtils.set(key,val,time);
            Map<String, Object> map1=new HashMap<>();
            map1.put("formvalueid",id);
            map1.put("timeout",time);
            return BackCodeUtils.getSuccess(map1);
        }else{
            return BackCodeUtils.getFail();
        }

    }
}
