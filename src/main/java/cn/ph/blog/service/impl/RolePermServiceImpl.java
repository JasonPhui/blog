package cn.ph.blog.service.impl;

import cn.ph.blog.dao.db1.RolePermMapper;
import cn.ph.blog.model.RolePerm;
import cn.ph.blog.service.RolePermService;
import cn.ph.blog.core.universal.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* @Description: RolePermService接口实现类
*/
@Service
public class RolePermServiceImpl extends AbstractService<RolePerm> implements RolePermService {

    @Resource
    private RolePermMapper rolePermMapper;

}

