package com.hltx.form.controller;

import com.hltx.beans.FormPage;
import com.hltx.form.config.UploadConfig;
import com.hltx.form.service.FormPageService;
import com.hltx.tool.BackCodeUtils;
import com.hltx.tool.PrimarykeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("formPage")
@RestController
public class FormPageController {

    @Autowired
    FormPageService formPageService;
    @Autowired
    UploadConfig uploadConfig;


    @PostMapping(value = "insertFormPage")
    public Map<String,Object> insertFormPage(FormPage formPage){
        formPage.setId(PrimarykeyUtil.getUUID());
        int t=formPageService.insertFormPage(formPage);
        if (t>0)
            return BackCodeUtils.getSuccess("SUCCESS");
        else
            return BackCodeUtils.getFail();
    }

    @GetMapping(value = "deleteFormPage")
    public Map<String,Object> deleteFormPage(String id){
        if (formPageService.deleteFormPage(id)>0)
            return BackCodeUtils.getSuccess("SUCCESS");
        else
            return BackCodeUtils.getFail();
    }

    @PostMapping(value = "updateFormStatus")
    public Map<String,Object> updateFormStatus(FormPage formPage){
        FormPage formPage1= formPageService.getByid(formPage.getId());
        if (formPage1==null){
            return BackCodeUtils.getNan();
        }else{
            if (formPage1.getStatus()==2){
                return BackCodeUtils.getOtherFail("已经发布的页面不能修改");
            }
        }
        if (formPageService.updateFormStatus(formPage)>0)
            return BackCodeUtils.getSuccess("SUCCESS");
        else
            return BackCodeUtils.getFail();
    }

    @GetMapping(value = "getByid")
    public Map<String,Object> getByid(String id){
        FormPage formPage=formPageService.getByid(id);
        if (formPage==null)
            return BackCodeUtils.getNan();
        else
            return BackCodeUtils.getSuccess(formPage);
    }

    @GetMapping(value = "getByPage")
    public Map<String,Object> getByPage(String key, @RequestParam(defaultValue = "0",required = false) Integer index,
                                        @RequestParam(defaultValue = "15",required = false) Integer pagesize, Integer companyid) {
        int count=formPageService.getCount(key, companyid);
        List<FormPage> formPages=formPageService.getByPage(key, index, pagesize, companyid);
        if (formPages!=null){
            Map<String,Object> map=new HashMap<>();
            map.put("code","10000");
            map.put("message","SUCCESS");
            map.put("count",count);
            map.put("data",formPages);
            return map;
        }else {
            return BackCodeUtils.getNan();
        }
    }

    @PostMapping(value = "uploadimg")
    public Map<String,Object> uploadimg(MultipartFile file){
        String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String filename= PrimarykeyUtil.getUUID()+ext;
        String path=uploadConfig.getImgpath() + filename;
        try {
            file.transferTo(new File(path));
            return BackCodeUtils.getSuccess(filename);
        } catch (IOException e) {
            e.printStackTrace();
            return BackCodeUtils.getExcept();
        }
    }

    @PostMapping(value = "uploadvideo")
    public Map<String,Object> uploadvideo(MultipartFile file){
        String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String filename= PrimarykeyUtil.getUUID()+ext;
        String path=uploadConfig.getVideopath() + filename;
        try {
            file.transferTo(new File(path));
            return BackCodeUtils.getSuccess(filename);
        } catch (IOException e) {
            e.printStackTrace();
            return BackCodeUtils.getExcept();
        }
    }

    @GetMapping(value = "fabu")
    public Map<String,Object> fabu(String id){
        FormPage formPage= formPageService.getByid(id);
        if (formPage==null){
            return BackCodeUtils.getNan();
        }else
        {
            if (formPage.getStatus()==2){
                return BackCodeUtils.getOtherFail("该页面已发布");
            }else {
                int t=formPageService.fabu(id);
                if (t>0){
                    return BackCodeUtils.getSuccess("SUCCESS");
                }else {
                    return BackCodeUtils.getFail();
                }
            }
        }
    }

}
