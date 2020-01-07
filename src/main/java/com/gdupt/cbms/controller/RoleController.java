package com.gdupt.cbms.controller;

import com.gdupt.cbms.core.bean.RestResponse;
import com.gdupt.cbms.entity.shiro.Role;
import com.gdupt.cbms.entity.shiro.User;
import com.gdupt.cbms.entity.vo.RoleVO;
import com.gdupt.cbms.service.RoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* @Name:RoleController
* @Description:这个是管理角色信息的控制器
* @Date:2019
* */

@Controller
@RequestMapping("/role")
public class RoleController extends BaseRestController{

    @Autowired
    private RoleService roleService;

    /*
    * @Description:这个是添加角色的方法
    * @Param:Role(Class)
    * @Date:2019
    * */
    @PostMapping
    @ResponseBody
    public RestResponse save(@RequestBody RoleVO role){
        System.out.println(role);
        boolean roleAfter = roleService.save(role);
        if (roleAfter){
            return success("操作成功");
        } else{
            return fail("操作失败","01",0,null);
        }
    }

    /*
    * @Description:这个是获取所有角色的方法,给用户分配角色的时候使用
    * @ReturnType:T(泛型)
    * @Date:2019
    * */
    @GetMapping
    @ResponseBody
    public RestResponse<List<Role>> getRoles(){
        List<Role> roles = roleService.roles();
        int count = roles.size();
        return success("请求成功","0",count,roles);
    }

    @RequestMapping("/list")
    public String rolesPage(){
        return "role/role";
    }

    @RequestMapping("/editPage")
    public String roleEditPage(int id,Model model){
        Role role = roleService.role(id);
        model.addAttribute("role",role);
        return "role/edit";
    }

    @RequestMapping("/addPage")
    public String roleAddPage(){
        return "role/add";
    }


    /*
    * @Description:这个是删除角色的方法
    * @Param:id(int)
    * @Date:2019
    * */
    @DeleteMapping("/{id}")
    @ResponseBody
    public RestResponse roleDel(@PathVariable("id") int id){
        Boolean result = roleService.delete(id);
        if(result){
            return success("操作成功");
        }
        return fail("操作失败","01",0,null);
    }

    /*
    * @Descritption:根据id获取单个角色用来修改操作之前的显示操作
    * @Param:id(int)
    * @Date:2019
    * */
    @GetMapping("/id/{id}")
    @ResponseBody
    public RestResponse<Role> findOneRoleById(@PathVariable("id") int id){
        Role role = roleService.role(id);
        return success(role);
    }

    /*
     * @Description:这个是角色的修改
     * @Param:Role
     * @Date:2019
     * */
    @PutMapping
    @ResponseBody
    public RestResponse<Role> update(@RequestBody Role role){
        System.out.println("这个修改的角色信息是："+role);
        Role roleAfter = roleService.update(role);
        if (roleAfter!=null){
            return success(roleAfter);
        }
        return fail("操作失败","01",0,null);
    }

    /*
    * @Description:这个是根据名字进行角色的模糊查询
    * @Date:2019
    * */
    @ResponseBody
    @GetMapping(value = "/name/{name}")
    public RestResponse<List<Role>> findRoleByName(@PathVariable("name") String name){
        List<Role> roleList = roleService.findRoleList(name);
        return success(roleList);
    }



    /*
    * @Name:getUserListFromRoleGroupByRoleId()
    * @Description:这个是根据角色ID获取该角色下面的用户列表
    * @Param:roleId(int)
    * @Date:2019
    * */
    @ResponseBody
    @GetMapping("/getUsers/{id}")
    public RestResponse<List<User>> getUserListFromRoleGroupByRoleId(@PathVariable("id") int RoleId){
        List<User> userList = roleService.getUserListByRoleId(RoleId);
        return success(userList);
    }

}
