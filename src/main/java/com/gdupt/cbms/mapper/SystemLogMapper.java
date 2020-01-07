package com.gdupt.cbms.mapper;


import com.gdupt.cbms.entity.po.SystemLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SystemLogMapper {
    public Integer save(SystemLog systemLog);
    public List<SystemLog> findAllLogs();
}
