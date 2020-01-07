package com.gdupt.cbms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdupt.cbms.core.util.TreeUtil;
import com.gdupt.cbms.entity.po.Perm;
import com.gdupt.cbms.entity.shiro.Permission;
import com.gdupt.cbms.entity.shiro.Role;
import com.gdupt.cbms.mapper.PermissionMapper;
import com.gdupt.cbms.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper,Permission> implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public boolean save(Permission permission) {
        Integer result = permissionMapper.save(permission);
        if(result>0)
            return true;
        return false;
    }

    @Override
    public Boolean deleteById(Integer id) {
        int effectRow = permissionMapper.permissionDelById(id);
        if (effectRow>0){
            return true;
        }
        return false;
    }

    @Override
    public Permission update(int id, Permission permission) {

        return null;
    }

    @Override
    public List<Permission> Permissions() {
        return permissionMapper.permissions();
    }

    @Override
    public List<Permission> getByMap(Map<String, Object> map) {
        return null;
    }

    @Override
    public List<Permission> permissionsByRole(List<Role> role) {
        return null;
    }

    @Override
    public Permission getById(Integer id) {
        return null;
    }

    @Override
    public List<Permission> getMenu() {
        //从数据库中查询出所有的权限
        List<Permission> permissionList = permissionMapper.permissions();
        //将上一步找出的所有权限做递归排序父子节点，并且返回树的形式的结果集合
        Collection<Permission> permissions = TreeUtil.toTree(permissionList, "id", "pid", "children", Permission.class);
        //将collection转化为List格式
        List resultToTreelist;
        if (permissions instanceof List)
            resultToTreelist = (List)permissions;
        else
            resultToTreelist = new ArrayList(permissions);
        //返回树形权权限集合
        System.out.println(resultToTreelist);
        return resultToTreelist;
    }

    @Override
    public List<Permission> getPermission() {
        //从数据库中查询出所有的权限
        List<Perm> permissionList = permissionMapper.getPermission();
        //将上一步找出的所有权限做递归排序父子节点，并且返回树的形式的结果集合
        Collection<Perm> permissions = TreeUtil.toTree(permissionList, "id", "pid", "children", Perm.class);
        //将collection转化为List格式
        List resultToTreelist;
        if (permissions instanceof List)
            resultToTreelist = (List)permissions;
        else
            resultToTreelist = new ArrayList(permissions);
        //返回树形权权限集合
        System.out.println(resultToTreelist);
        return resultToTreelist;
    }


}
