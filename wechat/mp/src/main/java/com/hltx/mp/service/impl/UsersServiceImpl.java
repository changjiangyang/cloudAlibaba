package com.hltx.mp.service.impl;

import com.hltx.mp.beans.Users;
import com.hltx.mp.mapper.UsersMapper;
import com.hltx.mp.service.UsersService;
import com.hltx.mp.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: ycj
 * Date: 2020/8/17
 * Time: 16:34
 * Description:
 */
@Service("usersService")
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    RedisUtils redisUtils;

    @Override
    public int updateQrcode(String openid, String imgpath) {
        return usersMapper.updateQrcode(openid, imgpath);
    }

    @Override
    public Users getUsersByOpenid(String openid) {
        return usersMapper.getUsersByOpenid(openid);
    }

    @Override
    public int insertSelective(Users users) {
        return usersMapper.insertSelective(users);
    }

    @Override
    public int updateUsers(Users users) {
        return usersMapper.updateUsers(users);
    }

    @Override
    public int getCount() {
        if (redisUtils.get("usercount")!=null)
            return (int) redisUtils.get("usercount");
        else
            return usersMapper.getCount();
    }

    @Override
    public List<Users> getUsersPage(Integer index, Integer pagesize) {
        return usersMapper.getUsersPage(index, pagesize);
    }
}
