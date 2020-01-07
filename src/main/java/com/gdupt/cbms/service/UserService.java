package com.gdupt.cbms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gdupt.cbms.entity.shiro.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService extends IService<User> {
    //检查是否存在同名.
    public boolean hasName(String userName);
    //添加用户.
    public boolean save(User user);


    //查询所有的用户.
    public List<User> users(int page, int limit);
    //根据Id查询.
    public User findUserById(Integer id);
    //根据用户名进行查询用户的全部信息.
    public User findOneUserByName(String userName);
    //根据名称来进行模糊查询
    public PageInfo<User> findUserByName(String userName,int page,int rows);
    //查询唯一的名称
    public User findOneUserById(Integer userId);
    //查询User来完成登录认证
    public User findUserToLogin(String userName);


    //根据id来进行完善信息
    public User complete(User user);
    //修改用户
    public User updateUserById(User user);
    public String findPermissionById(Integer id);


    //删除用户
    public Boolean deleteById(Integer id);

}
