package cn.ph.blog.service.impl;

import cn.ph.blog.dao.db1.SysRoleMapper;
import cn.ph.blog.model.SysRole;
import cn.ph.blog.service.SysRoleService;
import cn.ph.blog.core.universal.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* @Description: SysRoleService接口实现类
*/
@Service
public class SysRoleServiceImpl extends AbstractService<SysRole> implements SysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

}

