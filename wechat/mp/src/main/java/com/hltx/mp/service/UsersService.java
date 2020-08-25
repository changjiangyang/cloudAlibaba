package com.hltx.mp.service;

import com.hltx.mp.beans.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * User: ycj
 * Date: 2020/8/17
 * Time: 16:34
 * Description:
 */
public interface UsersService {

    int updateQrcode(String openid,String imgpath);

    Users getUsersByOpenid(String openid);

    int insertSelective(Users users);

    int updateUsers(Users users);

    int getCount();

    List<Users> getUsersPage(Integer index, Integer pagesize);
}
