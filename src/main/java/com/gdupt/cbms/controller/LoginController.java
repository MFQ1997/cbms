package com.gdupt.cbms.controller;

import com.gdupt.cbms.core.annotation.SysLog;
import com.gdupt.cbms.core.bean.RestResponse;
import com.gdupt.cbms.entity.shiro.User;
import com.gdupt.cbms.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*
 * @Name:LoginController
 * @Description:负责处理登录相关的控制器
 * @Date：2019-11
 * */

@Controller
public class LoginController extends BaseRestController{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping("/logi")
    public String loginPage(){
        return "/login/login";

    }

    @RequestMapping("/reg")
    public String register(){
        return "/login/reg";
    }

    @RequestMapping("/forget")
    public String forget(){
        return "/login/forget";
    }
    /*
    * @Name:login
    * @Description:这个是登录的验证接口,当验证通过之后就将该用户对应的角色所拥有权限返回给前端进行管理
    * @param:User(Class类型)
    * @ReturnType：T
    * */
    @SysLog(value = "登录操作")  //这里添加了AOP的自定义注解
    @RequestMapping("/login")
    @ResponseBody
    public RestResponse<User> login(String userName, String password) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        //模拟前端传递过来的用户登录信息
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUserName(), user.getPassword());
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(usernamePasswordToken);
            User userObject = userService.findOneUserByName(userName);
            return success(userObject);
            //subject.checkRole("admin");
            //subject.checkPermissions("query", "add");
        } catch (AuthenticationException e) {
            //e.printStackTrace();
            return fail("账号或密码错误","01",0,null);
        } catch (AuthorizationException e) {
            //e.printStackTrace();
            return fail("没有权限","01",0,null);
        }
    }

    /*
    * @Name:logout
    * @Description:这个是退出登录的方法
    * */
    @ResponseBody
    @RequestMapping("/logout")
    public RestResponse logout(){
        System.out.println("退出");
        //开始清除session的信息
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        //重定向页面
        return success("退出成功");
    }

    /*
    * @Name:changePwd()
    * @Description:这个是修改密码的方法
    * @Param:userId(int),password(String)
    * */
    @ResponseBody
    @PutMapping
    public RestResponse changePwd(int userId,String password){
        return success("操作成功");
    }

    /*
    * @Description:这个是未授权的跳转，返回未授权提示信息
    * @ReturnType:T(泛型)
    * */
    @ResponseBody
    @RequestMapping("/unAuth")
    public RestResponse unAuth(){
        return fail("未授权","401",0,null);
    }
}
