package com.gdupt.cbms.mapper;


import com.gdupt.cbms.entity.po.Setting;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SystemMapper{
    //获取系统的设置信息
    public Setting getSetting();

}
