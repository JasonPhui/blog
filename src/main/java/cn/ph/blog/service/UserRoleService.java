package cn.ph.blog.service;

import cn.ph.blog.model.UserRole;
import cn.ph.blog.core.universal.Service;

import java.util.List;

/**
* @Description: UserRoleService接口
*/
public interface UserRoleService extends Service<UserRole> {
    List<String> getRolesByUserId(String userId);
}
