package cn.ph.blog.service;

import cn.ph.blog.model.SystemLog;
import cn.ph.blog.core.universal.Service;

import java.util.List;

/**
* @Description: SystemLogService接口
*/
public interface SystemLogService extends Service<SystemLog> {
    Integer insertByBatch(List<SystemLog> list);
}
