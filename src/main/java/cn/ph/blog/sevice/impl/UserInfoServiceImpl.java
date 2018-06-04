package cn.ph.blog.sevice.impl;

import cn.ph.blog.dao.UserInfoMapper;
import cn.ph.blog.model.UserInfo;
import cn.ph.blog.sevice.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo selectById(Integer id) {
        return userInfoMapper.selectById(id);
    }
}
