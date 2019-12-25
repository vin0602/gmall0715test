package com.atguigu.gmall.service.impl;

import com.atguigu.gmall.bean.UserInfo;
import com.atguigu.gmall.mapper.UserInfoMapper;
import com.atguigu.gmall.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserManageSeerviceImpl implements UserManageService {

    @Autowired
    private UserInfoMapper userInfoMapper;


    @Override
    public List<UserInfo> findAll() {
        return userInfoMapper.selectAll();
    }

    @Override
    public UserInfo getUserInfoByName(String name) {
        return null;
    }

    @Override
    public List <UserInfo> getUserInfoListByName(UserInfo userInfo) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("name", userInfo.getName());

        return userInfoMapper.selectByExample(example);
    }

    @Override
    public List <UserInfo> getUserInfoListByNickName(UserInfo userInfo) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andLike("nickName","%"+userInfo.getNickName()+"%");
        List <UserInfo> infoList = userInfoMapper.selectByExample(example);
        return infoList;
    }

    @Override
    public void addUser(UserInfo userInfo) {
        userInfoMapper.insertSelective(userInfo);
    }


    @Override
    public void updUser(UserInfo userInfo) {
        //update from userInfo set name=? where id = ?
        //userInfoMapper.updateByPrimaryKey(userInfo);

        //update from userInfo set name = ? where id = ?
        //userInfoMapper.updateByPrimaryKeySelective(userInfo);

        //update from userInfo set name = ? where id = ？
        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("name",userInfo.getName());

        userInfoMapper.updateByExampleSelective(userInfo,example);

    }

    @Override
    public void delUser(UserInfo userInfo) {
        //delete from userInfo  where id = ?
//        Example example = new Example(UserInfo.class);
//        example.createCriteria().andEqualTo("name",userInfo.getName());
//        userInfoMapper.deleteByExample(example);

        userInfoMapper.delete(userInfo);

    }
}
