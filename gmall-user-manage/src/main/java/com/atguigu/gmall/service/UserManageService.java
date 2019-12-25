package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.UserInfo;
import org.apache.catalina.User;

import java.util.List;

//业务逻辑层
public interface UserManageService {

    /**
     * 查询所有数据的用户
     * @return
     */
    List<UserInfo> findAll();


    /**
     * 根据名字查询用户信息
     * @param name
     * @return
     */
    UserInfo getUserInfoByName(String name);

    /**
     * 根据姓名查询用户
     * @param userInfo
     * @return
     */
    List<UserInfo> getUserInfoListByName(UserInfo userInfo);

    /**
     *
     * @param userInfo
     * @return
     */
    List<UserInfo> getUserInfoListByNickName(UserInfo userInfo);

    /**
     * 添加用户信息
     * @param userInfo
     */
    void  addUser(UserInfo userInfo);

    /**
     * 修改用户信息
     * @param userInfo
     */
    void updUser(UserInfo userInfo);


    /**
     * 删除用户
     * @param userInfo
     */
    void  delUser(UserInfo userInfo);




}
