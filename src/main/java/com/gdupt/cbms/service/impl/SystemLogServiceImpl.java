package com.gdupt.cbms.service.impl;


import com.gdupt.cbms.entity.po.SystemLog;
import com.gdupt.cbms.mapper.SystemLogMapper;
import com.gdupt.cbms.service.SystemLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemLogServiceImpl implements SystemLogService {

    @Autowired
    private SystemLogMapper systemLogMapper;

    /*
    * @Description:这个是插入日志到数据库中
    * @Param:systemLog 蕴含数据的日志对象
    * @ReturnType:boolean
    * */
    @Override
    public boolean save(SystemLog systemLog) {
        int result = systemLogMapper.save(systemLog);
        if(result>0){
            return true;
        }
        return false;
    }

    /*
    * @Description:这个是获取所有操作日志的服务，并且进行分页返回数据
    * @Param：page 表示显示第几页的内容
    * @Param: rows 表示一页显示多少条信息
    * @ReturnValue:pageData 分页之后的数据列表集合
    * */
    @Override
    public PageInfo<SystemLog> findAllLogs(int page , int rows) {
        PageHelper.startPage(page,rows);
        List<SystemLog> logList = systemLogMapper.findAllLogs();
        PageInfo<SystemLog> pageData = new PageInfo<SystemLog>(logList);
        return pageData;
    }
}
