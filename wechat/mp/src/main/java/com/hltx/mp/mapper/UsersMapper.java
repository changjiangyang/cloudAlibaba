package com.hltx.mp.mapper;

import com.hltx.mp.beans.Users;
import org.apache.ibatis.annotations.Param;
import org.apache.tomcat.jni.User;

import java.util.List;

public interface UsersMapper {

    int updateQrcode(@Param("openid") String openid, @Param("imgpath") String imgpath);

    Users getUsersByOpenid(@Param("openid") String openid);

    int insertSelective(Users users);

    int updateUsers(Users users);

    int getCount();

    List<Users> getUsersPage(@Param("index") Integer index,@Param("pagesize") Integer pagesize);

    List<Users> getMytuijian(String openid);
}