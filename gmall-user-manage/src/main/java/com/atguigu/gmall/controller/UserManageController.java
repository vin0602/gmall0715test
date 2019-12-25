package com.atguigu.gmall.controller;


import com.atguigu.gmall.bean.UserInfo;
import com.atguigu.gmall.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Source;
import java.util.List;

@RestController
public class UserManageController {

    @Autowired
    private UserManageService userManageService;

    @RequestMapping("findAll")
    public List<UserInfo> findAll(){
        return userManageService.findAll();
    }

    @RequestMapping("findUserByName")
    public List<UserInfo> findUserByName(UserInfo userInfo){
        return userManageService.getUserInfoListByName(userInfo);
    }

    @RequestMapping("getUserInfoListByNickName")
    public List<UserInfo> getUserInfoListByNickName(UserInfo userInfo){
        return userManageService.getUserInfoListByNickName(userInfo);
    }

    @RequestMapping("addUser")
    public void addUser(UserInfo userInfo){
        userInfo.setName("高手");
        userInfo.setLoginName("武灵高手");
        userInfo.setNickName("仙界高手");
        userManageService.addUser(userInfo);

        System.out.println("id ==========" + userInfo.getId());
    }

    @RequestMapping("updUser")
    public void updUser(UserInfo userInfo){
        userManageService.updUser(userInfo);
    }

    @RequestMapping("delUser")
    public void delUser(UserInfo userInfo){
        userManageService.delUser(userInfo);
    }


}
