package cn.ph.blog.dao.db1;

import cn.ph.blog.core.universal.Mapper;
import cn.ph.blog.model.SysPermissionInit;

import java.util.List;

public interface SysPermissionInitMapper extends Mapper<SysPermissionInit> {
    List<SysPermissionInit> selectAllOrderBySort();
}