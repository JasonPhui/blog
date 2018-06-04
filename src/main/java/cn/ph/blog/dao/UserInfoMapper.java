package cn.ph.blog.dao;

import cn.ph.blog.model.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface UserInfoMapper {
    UserInfo selectById(@Param("id") Integer id);
}
