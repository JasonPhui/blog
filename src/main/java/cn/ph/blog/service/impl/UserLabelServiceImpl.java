package cn.ph.blog.service.impl;

import cn.ph.blog.dao.db2.UserLabelMapper;
import cn.ph.blog.model.UserLabel;
import cn.ph.blog.service.UserLabelService;
import cn.ph.blog.core.universal.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* @Description: UserLabelService接口实现类
*/
@Service
public class UserLabelServiceImpl extends AbstractService<UserLabel> implements UserLabelService {

    @Resource
    private UserLabelMapper userLabelMapper;

}

