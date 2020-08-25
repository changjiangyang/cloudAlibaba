package com.hltx.mp.controller;

import com.hltx.mp.beans.Producet;
import com.hltx.mp.config.UploadConfig;
import com.hltx.mp.service.ProducetService;
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

/**
 * User: ycj
 * Date: 2020/8/18
 * Time: 10:26
 * Description:
 */
@RestController
@RequestMapping("producet")
public class ProducetController {

    @Autowired
    ProducetService producetService;
    @Autowired
    UploadConfig uploadConfig;

    @PostMapping(value = "addProducet")
    public Map<String,Object> addProducet(Producet producet, MultipartFile img ,MultipartFile thumbnail) throws IOException {
        producet.setProId(PrimarykeyUtil.getUUID());
        // TODO 商品展示图
        String imgsuffix = PrimarykeyUtil.getUUID()+"."+img.getOriginalFilename().substring(img.getOriginalFilename().lastIndexOf(".") + 1);
        String imgname=uploadConfig.getImgpath()+"/"+imgsuffix;
        img.transferTo(new File(imgname));
        producet.setProImg(imgsuffix);
        // TODO 缩略图
        String thumbnailsuffix = PrimarykeyUtil.getUUID()+"."+thumbnail.getOriginalFilename().substring(thumbnail.getOriginalFilename().lastIndexOf(".") + 1);
        String thumbnailname=uploadConfig.getImgpath()+"/"+thumbnailsuffix;
        thumbnail.transferTo(new File(thumbnailsuffix));
        producet.setProThumbnail(thumbnailname);
        int t=producetService.insertSelective(producet);
        if (t>0)
            return BackCodeUtils.getSuccess(producet);
        else
            return BackCodeUtils.getFail();
    }

    @PostMapping(value = "changeStatus")
    public Map<String,Object> changeStatus(String proid,Integer status){
        Producet producet=new Producet();
        producet.setProId(proid);
        producet.setProStatus(status);
        int t=producetService.updateByPrimaryKeySelective(producet);
        if (t>0)
            return BackCodeUtils.getSuccess("SUCCESS");
        else
            return BackCodeUtils.getFail();
    }

    @PostMapping(value = "recommended")
    public Map<String,Object> changeRecommended(String proid,Integer recommended){
        Producet producet=new Producet();
        producet.setProId(proid);
        producet.setProRecommended(recommended);
        int t=producetService.updateByPrimaryKeySelective(producet);
        if (t>0)
            return BackCodeUtils.getSuccess("SUCCESS");
        else
            return BackCodeUtils.getFail();
    }

    @GetMapping(value = "getCount")
    public Map<String,Object> getCount(){
        int t=producetService.getCount();
        if (t>0)
            return BackCodeUtils.getSuccess("SUCCESS");
        else
            return BackCodeUtils.getFail();
    }

    @RequestMapping(value = "getByPage",method = RequestMethod.GET)
    public Map<String,Object> getByPage(@RequestParam(defaultValue = "0",required = false) Integer index,
                                        @RequestParam(defaultValue = "15",required = false) Integer pagesize){
        int count =producetService.getCount();
        List<Producet> producets=producetService.getByPage(index, pagesize);
        Map<String,Object> map=new HashMap<>();
        map.put("count",count);
        map.put("prolist",producets);
        map.put("index",index);
        map.put("pagesize",pagesize);
        return BackCodeUtils.getSuccess(map);
    }

    @GetMapping(value = "deletePro")
    public Map<String,Object> deletePro(String proid){
        int t=producetService.deleteByPrimaryKey(proid);
        if (t>0)
            return BackCodeUtils.getSuccess("SUCCESS");
        else
            return BackCodeUtils.getFail();
    }

    @PostMapping(value = "uploadImg")
    public Map<String ,Object> uploadImg(MultipartFile file){
        String ext=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        System.out.println(ext);
        String imgpath=PrimarykeyUtil.getUUID()+ext;
        System.out.println(imgpath);
        String path=uploadConfig.getImgpath()+imgpath;
        try {
            file.transferTo(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return BackCodeUtils.getSuccess(imgpath);

    }
}
