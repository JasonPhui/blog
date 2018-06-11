package cn.ph.blog.dao;

import cn.ph.blog.model.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoMapper {
    UserInfo selectById(@Param("id") Integer id);
    List<UserInfo> selectAll();
}
