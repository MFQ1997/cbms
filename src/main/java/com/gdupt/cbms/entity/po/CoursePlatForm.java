package com.gdupt.cbms.entity.po;

/*
* @Name:CoursePlatForm
* @Description:这个是课程平台的实体类
* @Date:2019
* */

public class CoursePlatForm extends Course{

    private String id;
    private int courseId;                       //课程编号
    private String courseName;					//课程名称
    private String courseClassify;				//课程分类
    private String PFId;						//课程平台编号
    private String PfName;						//课程平台名称

    private String room;						//教研室
    private String theoryHours;					//理论学时
    private String practiceHours;				//实践学时
    private String totalHours;					//总学时
    private double courseScore; 				//课程学分
    private String markMode;					//成绩方式
    private String suitScope;					//使用范围
    private String responsibleUnit;				//负责单位
    private String status;						//课程状态


}
