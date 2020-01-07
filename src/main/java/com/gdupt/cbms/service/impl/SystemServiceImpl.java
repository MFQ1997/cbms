package com.gdupt.cbms.service.impl;


import com.gdupt.cbms.entity.po.Setting;
import com.gdupt.cbms.mapper.SystemMapper;
import com.gdupt.cbms.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    private SystemMapper systemMapper;

    @Override
    public Setting getSetting() {
        return systemMapper.getSetting();
    }

}
