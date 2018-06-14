package cn.ph.blog.service;

import cn.ph.blog.core.universal.Service;
import cn.ph.blog.model.UserInfo;
import com.github.pagehelper.PageInfo;

public interface UserInfoService extends Service<UserInfo> {
//    UserInfo selectById(Integer id);
    PageInfo<UserInfo> selectAllByPage(Integer page, Integer size);
}
