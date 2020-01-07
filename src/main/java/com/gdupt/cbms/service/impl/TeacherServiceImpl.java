package com.gdupt.cbms.service.impl;

import com.gdupt.cbms.entity.po.Teacher;
import com.gdupt.cbms.mapper.TeacherMapper;
import com.gdupt.cbms.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    /*
     * @Description:新增教师
     * @Date:2019
     * */
    @Override
    public Integer save(Teacher teacher) {
        return teacherMapper.save(teacher);
    }

    /*
    * @Description:获取所有的教师信息
    * @Date:2019
    * */
    @Override
    public List<Teacher> getAllTeacher() {
        return teacherMapper.getAllTeacher();
    }

    /*
     * @Description:根据教师Id获取教师的信息
     * @Date:2019
     * */
    @Override
    public Teacher getOneTeacherById(Integer id) {
        return teacherMapper.getOneTeacherById(id);
    }

    /*
    * @Description:根据关键字进行模糊查询
    * @Date:2019
    * */
    @Override
    public List<Teacher> getTeacherLikeKey(String key,String name) {
        return null;
    }

    @Override
    public boolean fakeDeleteById(Integer id) {
        return false;
    }

    @Override
    public boolean update(Teacher teacher) {
        return false;
    }
}
