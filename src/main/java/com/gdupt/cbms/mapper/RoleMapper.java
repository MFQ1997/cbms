package com.gdupt.cbms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.gdupt.cbms.entity.shiro.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    //添加角色
    public int save(Role role);
    //删除角色
    public Boolean delete(Integer id);
    //修改角色
    public int update(Role role);
    //获取所有的角色
    public List<Role> roles();
    //角色模糊查询
    public List<Role> findRoleByName(String roleName);
    //根据id获取到用户角色
    public Role role(Integer id);
}
