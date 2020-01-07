package com.gdupt.cbms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.gdupt.cbms.entity.shiro.Role;
import com.gdupt.cbms.entity.shiro.User;
import com.gdupt.cbms.mapper.RoleMapper;
import com.gdupt.cbms.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public boolean save(Role role) {
        int result = roleMapper.save(role);
        if(result>0){
            return true;
        }
        return false;
    }

    @Override
    public List<Role> findRoleList(String roleName) {
        return roleMapper.findRoleByName(roleName);
    }

    @Override
    public Boolean delete(Integer id) {
        return roleMapper.delete(id);
    }

    @Override
    public Role update(Role role) {
        return null;
    }

    @Override
    public List<Role> roles() {
        List<Role> roleList = roleMapper.roles();
        return roleList;
    }

    @Override
    public List<User> getUserListByRoleId(Integer id) {
        return null;
    }

    @Override
    public Role role(Integer id) {
        return roleMapper.role(id);
    }
}
