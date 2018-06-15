package cn.ph.blog.service.impl;

import cn.ph.blog.dao.db1.SystemLogMapper;
import cn.ph.blog.model.SystemLog;
import cn.ph.blog.service.SystemLogService;
import cn.ph.blog.core.universal.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @Description: SystemLogService接口实现类
*/
@Service
public class SystemLogServiceImpl extends AbstractService<SystemLog> implements SystemLogService {

    @Resource
    private SystemLogMapper systemLogMapper;

}

