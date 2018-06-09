package cn.ph.blog.sevice.impl;

import cn.ph.blog.core.ret.ServiceException;
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
        UserInfo userInfo = userInfoMapper.selectById(id);
        if(userInfo == null){
            throw new ServiceException("暂无该用户");
        }
        return userInfo;
    }
}
