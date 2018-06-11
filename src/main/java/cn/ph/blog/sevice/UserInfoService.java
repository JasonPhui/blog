package cn.ph.blog.sevice;

import cn.ph.blog.model.UserInfo;
import com.github.pagehelper.PageInfo;

public interface UserInfoService {
    UserInfo selectById(Integer id);
    PageInfo<UserInfo> selectAll(Integer page, Integer size);
}
