package cn.ph.blog.dao.db1;

import cn.ph.blog.core.universal.Mapper;
import cn.ph.blog.model.RolePerm;

import java.util.List;

public interface RolePermMapper extends Mapper<RolePerm> {
    List<String> getPermsByUserId(String userId);
}