package com.gdupt.cbms.controller;

import com.gdupt.cbms.core.bean.RestResponse;
import com.gdupt.cbms.entity.po.Setting;
import com.gdupt.cbms.entity.po.SystemLog;
import com.gdupt.cbms.entity.shiro.Permission;
import com.gdupt.cbms.service.PermissionService;
import com.gdupt.cbms.service.SystemLogService;
import com.gdupt.cbms.service.SystemService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/*
* @Name:SystemController
* @Description:这个是管理系统设置的Controller（例如设置系统的名称、域名信息、备案号等等,此外还有七牛云账号，操作日志等等的模块管理）
* @Date:2019
* */

@Controller
@RequestMapping("/setting")
public class SettingController extends BaseRestController{

    @Autowired
    private SystemService systemService;

    @Autowired
    private SystemLogService systemLogService;

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/email")
    public String email(){
        return "/setting/email";
    }

    @RequestMapping("/website")
    public String website(){
        System.out.println("WebSite's Page");
        return "/setting/website";
    }

    @RequestMapping("/info")
    public String info(){
        return "/setting/info";
    }

    @RequestMapping("/password")
    public String password(){
        return "/setting/password";
    }
    /*
     * @Descirption:获取到所有数据库连接字符串
     * */
    @ResponseBody
    @GetMapping("/setting")
    public RestResponse<Setting> getSettings() throws Exception{
        //获取网站的设置信息
        Setting setting = systemService.getSetting();
        return success(setting);
    }

    // ____________系统操作日志____________-_-
    /*
    * @Description:这个是获取所有系统操作日志的方法
    * @Date:2019
    * */
    @GetMapping("/logs")
    @ResponseBody
    public RestResponse<PageInfo<SystemLog>> systemLogList(@RequestParam(value="page",defaultValue="1")int page, @RequestParam(value="rows",defaultValue="10")int rows){
        PageInfo<SystemLog> pageResult = systemLogService.findAllLogs(page,rows);
        return success(pageResult);
    }

    /*
    * @Description:这个是获取菜单信息返回到界面显示的，根据用户的id进行获取的
    * */
    @GetMapping("/menu")
    @ResponseBody
    public RestResponse<List<Permission>> getMenu(){
        System.out.println("查询菜单中");
        List<Permission> menuList = permissionService.getMenu();
        int count = menuList.size();
        return success("请求成功","0",count,menuList);
    }


}
