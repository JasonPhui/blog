package cn.ph.blog.service;

import cn.ph.blog.model.RolePerm;
import cn.ph.blog.core.universal.Service;

import java.util.List;

/**
* @Description: RolePermService接口
*/
public interface RolePermService extends Service<RolePerm> {
    List<String> getPermsByUserId(String userId);
}
