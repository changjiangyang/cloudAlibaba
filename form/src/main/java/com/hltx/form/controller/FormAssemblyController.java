package com.hltx.form.controller;

import com.hltx.beans.FormAssembly;
import com.hltx.form.config.UploadConfig;
import com.hltx.form.service.FormAssemblyService;
import com.hltx.form.util.RedisUtils;
import com.hltx.tool.BackCodeUtils;
import com.hltx.tool.PrimarykeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * User: ycj
 * Date: 2020/8/12
 * Time: 7:59
 * Description:
 */
@RestController
@RequestMapping("formAssembly")
public class FormAssemblyController {

    @Autowired
    private FormAssemblyService formAssemblyService;
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    UploadConfig uploadConfig;

    @GetMapping(value = "getAllFormAssembly")
    public Map<String ,Object> getAllFormAssembly(){
        System.out.println("sssss");
        if (redisUtils.get("AllFormAssembly")!=null)
            return BackCodeUtils.getSuccess(redisUtils.get("AllFormAssembly"));

        System.out.println("ddddd");
        List<FormAssembly> list=formAssemblyService.getAll();
        if (list==null)
            return BackCodeUtils.getFail();
        if (list.size()>0){
            redisUtils.set("AllFormAssembly",list);
            return BackCodeUtils.getSuccess(list);
        }else
            return BackCodeUtils.getNan();
    }

    @PostMapping(value = "addFormAssembly")
    public Map<String,Object> addFormAssembly(String name, MultipartFile icon){
        String filename = null;
        try {
           byte[] t= icon.getBytes();
           String suffix = icon.getOriginalFilename().substring(icon.getOriginalFilename().lastIndexOf(".") + 1);
           String path= uploadConfig.getImgpath();
            filename=UUID.randomUUID().toString().replace("-","")+icon.getName()+"."+suffix;
           String  filepath=path+"/"+filename ;
           icon.transferTo(new File(filepath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        FormAssembly formAssembly=new FormAssembly();
        formAssembly.setName(name);
        formAssembly.setIcon(filename);
        formAssembly.setId(UUID.randomUUID().toString().replace("-",""));
        int t=formAssemblyService.addFormassembly(formAssembly);
        if (t>0){
            redisUtils.del("AllFormAssembly");
            return BackCodeUtils.getSuccess(formAssembly);
        }
        else
            return BackCodeUtils.getFail();
    }

    @GetMapping(value = "deleteFormAssembly")
    public Map<String,Object> deleteFormAssembly(String id){
        int t=formAssemblyService.deleteFormassembly(id);
        if (t>0){
            redisUtils.del("AllFormAssembly");
            return BackCodeUtils.getSuccess("SUCCESS");
        }
        else
            return BackCodeUtils.getFail();
    }


}
