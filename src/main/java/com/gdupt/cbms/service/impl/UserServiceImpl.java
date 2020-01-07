package com.gdupt.cbms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.gdupt.cbms.entity.shiro.User;
import com.gdupt.cbms.mapper.UserMapper;
import com.gdupt.cbms.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    /*
    * @Description:获取所有的User
    * @Param:page 表示显示第几页内容
    * @Param:rows 表示一页显示多少条数据
    * @ReturnType: pageData 返回分页之后的数据
    * */
    @Override
    public List<User> users(int page, int limit) {
       // PageHelper.startPage(page,limit);
        List<User> users = userMapper.findAllUserWithRole();
        //PageInfo<User> pageData = new PageInfo<User>(users);
        return users;
    }

    @Override
    public boolean hasName(String userName) {
        User user = userMapper.hasName(userName);
        if(user == null)
            return false;
        return true;
    }

    @Transactional
    @Override
    public boolean save(User user) {
        //设置时间
        Timestamp createTime = new Timestamp(new Date().getTime());
        user.setCreateTime(createTime);
        user.setUpdateTime(createTime);
        //添加数据到user表
        int resultFromUser = userMapper.save(user);
        //添加数据到user_info表
        int resultFromUserInfo = userMapper.complete(user);
        //设置默认的普通用户的角色
        int resultFromRole = userMapper.setDefaultRole(user.getId());
        if (resultFromUser>0 && resultFromUserInfo >0 && resultFromRole>0){
            return true;
        }
        return false;
    }



    @Override
    public User findUserById(Integer id) {
        System.out.println(id);
        User user = userMapper.findUserById(id);
        return user;
    }

    @Override
    public User findOneUserByName(String userName) {
        return userMapper.findOneUserByName(userName);
    }

    @Override
    public User complete(User user) {
        userMapper.complete(user);
        return user;
    }

    /*
    * @Name:findUserByName
    * @Description:这个是通过传入名字来针对这个名字进行模糊查询
    * @Param:userName 表示传入的模糊查询的关键字
    * @Param：page 表示显示第几页的内容
    * @Param：rows 表示在一页中显示多少条的数据
    * */
    @Override
    public PageInfo<User> findUserByName(String userName,int page, int rows) {
        PageHelper.startPage(page,rows);
        List<User> users = userMapper.findUserByName(userName);
        PageInfo<User> pageData = new PageInfo<>(users);
        return pageData;
    }

    @Override
    public User findOneUserById(Integer userId) {
        User user = userMapper.findOneUserById(userId);
        return user;
    }

    @Override
    public User findUserToLogin(String userName) {
        return userMapper.findUserToLogin(userName);
    }


    @Override
    public Boolean deleteById(Integer id) {
        return userMapper.deleteById(id);
    }

    @Transactional
    @Override
    public User updateUserById( User user) {
        System.out.println("当前的用户对象是："+user);
        userMapper.updateUserById(user);
        userMapper.updateUser(user);
        return user;
    }

    @Override
    public String findPermissionById(Integer id) {
        return null;
    }

    public User findPermissionFromRoleByUserName(Integer userId){
        return userMapper.findPermissionFromRoleByUserName(userId);
    }

}
