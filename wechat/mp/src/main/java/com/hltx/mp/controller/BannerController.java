package com.hltx.mp.controller;

import com.hltx.mp.beans.Banner;
import com.hltx.mp.config.UploadConfig;
import com.hltx.mp.service.BannerService;
import com.hltx.tool.BackCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * User: ycj
 * Date: 2020/8/17
 * Time: 13:49
 * Description:
 */
@RestController
@RequestMapping("banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;
    @Autowired
    private UploadConfig uploadConfig;

    @GetMapping(value = "getAll")
    public Map<String,Object> getAll(){
        return BackCodeUtils.getSuccess(bannerService.getAll());
    }

    @PostMapping(value = "addBanner")
    public  Map<String,Object> addBanner(Integer paixu,String title, String uri, MultipartFile img){
        String filename = null;
        try {
            byte[] t= img.getBytes();
            if ((t.length > uploadConfig.getImgmaxsize())){
                return BackCodeUtils.getOutOfMaxSize("上传文件最大"+uploadConfig.getImgmaxsize()/1024/1024+"M");
            }
            String suffix = img.getOriginalFilename().substring(img.getOriginalFilename().lastIndexOf(".") + 1);
            String path= uploadConfig.getImgpath();
            filename= UUID.randomUUID().toString().replace("-","")+img.getName()+"."+suffix;
            String  filepath=path+"/"+filename ;
            img.transferTo(new File(filepath));
        } catch (IOException e) {
            e.printStackTrace();
            return BackCodeUtils.getExcept();
        }
        Banner banner=new Banner();
        banner.setPath(filename);
        banner.setUri(uri);
        banner.setSort(paixu);
        banner.setTitle(title);
        banner.setAddtime(new Date());
        int t=bannerService.insertSelective(banner);
        if (t>0)
            return BackCodeUtils.getSuccess("SUCCESS");
        else
            return BackCodeUtils.getFail();
    }

    @GetMapping(value = "deleteBanner")
    public Map<String,Object> deleteBanner(Integer id){
        return BackCodeUtils.getSuccess(bannerService.deleteByPrimaryKey(id));
    }
}
