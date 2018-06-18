package cn.ph.blog.service.impl;

import cn.ph.blog.dao.db1.SysPermMapper;
import cn.ph.blog.model.SysPerm;
import cn.ph.blog.service.SysPermService;
import cn.ph.blog.core.universal.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* @Description: SysPermService接口实现类
*/
@Service
public class SysPermServiceImpl extends AbstractService<SysPerm> implements SysPermService {

    @Resource
    private SysPermMapper sysPermMapper;

}

