package com.hltx.tool;

import java.util.UUID;

/**
 * User: ycj
 * Date: 2020/8/13
 * Time: 16:52
 * Description: 数据库主键生成
 */
public class PrimarykeyUtil {

    /**
     * UUID
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }



}
