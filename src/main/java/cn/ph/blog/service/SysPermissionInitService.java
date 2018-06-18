package cn.ph.blog.service;

import cn.ph.blog.model.SysPermissionInit;
import cn.ph.blog.core.universal.Service;

import java.util.List;

/**
* @Description: SysPermissionInitService接口
*/
public interface SysPermissionInitService extends Service<SysPermissionInit> {
    List<SysPermissionInit> selectAllOrderBySort();
}
