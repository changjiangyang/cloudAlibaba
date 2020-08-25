package com.hltx.mp.service.impl;

import com.hltx.mp.beans.Admin;
import com.hltx.mp.mapper.AddressMapper;
import com.hltx.mp.mapper.AdminMapper;
import com.hltx.mp.service.AdminService;
import com.hltx.mp.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: ycj
 * Date: 2020/8/19
 * Time: 15:00
 * Description:
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;
    @Autowired
    RedisUtils redisUtils;

    @Override
    public Admin login(String logname) {
        String key = "damin"+logname;
        Admin admin=adminMapper.login(logname);
        if (redisUtils.get(key)==null)
            redisUtils.set(key,admin);
        else
            return (Admin) redisUtils.get(key);
        return admin;
    }
}
