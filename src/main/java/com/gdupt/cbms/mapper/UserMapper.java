package com.gdupt.cbms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.gdupt.cbms.entity.shiro.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    //检查是否存在同名的
    public User hasName(String userName);
    //添加用户
    public Integer save(User user);
    //添加默认的普通用户角色
    public Integer setDefaultRole(Integer userId);
    //根据id进行用户登录
    public User findOneUserById(Integer userId);
    //根据id进行用户登录
    public User findOneUserByName(String userName);
    //查询所有的用户
    @Select("select * from t_user")
    public List<User> users();

    //查询全部用户的全部个人信息以及角色.
    public List<User> findAllUserWithRole();
    //获取用户拥有的权限
    public User findPermissionFromRoleByUserName(Integer userId);

    //根据Id查询
    public User findUserById(Integer id);
    //根据id来完善用户信息
    public Integer complete(User user);
    //根据名称来进行模糊查询
    public List<User> findUserByName(String userName);

    //查询用户用来完成登录认证
    public User findUserToLogin(String userName);
    //删除用户
    public Boolean deleteById(Integer id);
    //修改user表里面的信息
    public int updateUserById(User user);
    //修改user_info表的信息
    public int updateUser(User user);
}
