package cn.ph.blog.dao.db1;

import cn.ph.blog.core.universal.Mapper;
import cn.ph.blog.model.UserRole;

import java.util.List;

public interface UserRoleMapper extends Mapper<UserRole> {
    List<String> getRolesByUserId(String userId);
}