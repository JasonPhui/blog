package cn.ph.blog.service.impl;

import cn.ph.blog.dao.db1.UserRoleMapper;
import cn.ph.blog.model.UserRole;
import cn.ph.blog.service.UserRoleService;
import cn.ph.blog.core.universal.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* @Description: UserRoleService接口实现类
*/
@Service
public class UserRoleServiceImpl extends AbstractService<UserRole> implements UserRoleService {

    @Resource
    private UserRoleMapper userRoleMapper;

}

