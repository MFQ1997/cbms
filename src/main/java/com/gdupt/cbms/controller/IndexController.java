package com.gdupt.cbms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
* @Description:这个是首页的控制器
* @Date：2019
* */

@Controller
public class IndexController extends BaseRestController{

    @RequestMapping("/index")
    public String indexPage(Model model){
        model.addAttribute("name","高校基层管理系统");
        return "index";
    }

    @RequestMapping("/console")
    public String console(){
        return "console";
    }

}
