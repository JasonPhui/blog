package cn.ph.blog.sevice;

import cn.ph.blog.model.UserInfo;

public interface UserInfoService {
    UserInfo selectById(Integer id);
}
