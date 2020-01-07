package com.gdupt.cbms.mapper;

import com.gdupt.cbms.entity.po.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeacherMapper {
    //插入数据
    public Integer save(Teacher teacher);
    //获取所有教师
    public List<Teacher> getAllTeacher();
    //根据id获取单条记录
    public Teacher getOneTeacherById(Integer id);
    //根据关键字进行模糊查询
    public List<Teacher> getTeacherLikeKey(@Param("key") String key, @Param("name") String name);
    //进行伪删除
    public boolean fakeDeleteById(Integer id);
    //进行修改
    public boolean update(Teacher teacher);
}
