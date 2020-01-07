package com.gdupt.cbms.controller;

/*
* @Name:TeacherController
* @Description:这个是教师管理的控制器
* @Date:2019
* */

import com.gdupt.cbms.core.bean.RestResponse;
import com.gdupt.cbms.entity.po.Teacher;
import com.gdupt.cbms.service.TeacherService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController extends BaseRestController{

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/")
    public String teacherPage(){
        return "/teacher/list";
    }

    @RequestMapping("/add")
    public String teacherAddPage(){
        return "/teacher/add";
    }

    @RequestMapping("/edit")
    public String teacherEditPage(int id,Model model){
        Teacher teacher = teacherService.getOneTeacherById(id);
        model.addAttribute("teacher",teacher);
        return "/teacher/edit";
    }

    @GetMapping
    @ResponseBody
    public RestResponse<List<Teacher>> getTeacherList(){
        List<Teacher> data = teacherService.getAllTeacher();
        int count = data.size();
        return success("success","0",count,data);
    }

    @PostMapping
    @ResponseBody
    public RestResponse save(@RequestBody Teacher teacher){
        int count = teacherService.save(teacher);
        if (count>0){
            return success("success","0",count,null);
        }
        return fail("fail","0",0,null);
    }
}
