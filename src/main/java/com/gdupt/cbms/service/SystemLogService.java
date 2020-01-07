package com.gdupt.cbms.service;



import com.gdupt.cbms.entity.po.SystemLog;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SystemLogService {
    public boolean save(SystemLog systemLog);
    public PageInfo<SystemLog> findAllLogs(int page,int rows);
}
