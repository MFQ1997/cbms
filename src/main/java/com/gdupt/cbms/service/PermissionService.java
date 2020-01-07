package com.gdupt.cbms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gdupt.cbms.entity.shiro.Permission;
import com.gdupt.cbms.entity.shiro.Role;


import java.util.List;
import java.util.Map;

public interface PermissionService extends IService<Permission> {
    //添加权限信息
    public boolean save(Permission permission);
    public Boolean deleteById(Integer id);
    public Permission update(int id, Permission permission);
    public List<Permission> Permissions();

    public List<Permission> getByMap(Map<String, Object> map);
    //根据角色获取对应的权限
    public List<Permission> permissionsByRole(List<Role> role);
    public Permission getById(Integer id);
    public List<Permission> getMenu();
    public List<Permission> getPermission();

}
