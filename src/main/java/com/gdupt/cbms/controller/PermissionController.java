package com.gdupt.cbms.controller;

/*
* @Name:PermissionController
* @Description:这个是管理权限信息的控制器
* @Date:2019
* */

import com.gdupt.cbms.core.bean.RestResponse;
import com.gdupt.cbms.entity.shiro.Permission;
import com.gdupt.cbms.entity.shiro.Role;
import com.gdupt.cbms.service.PermissionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* @Name:PermissionController
* @Description:这个是管理权限信息的控制器
* @Date:2019
* */

@Controller
@RequestMapping("/permission")
public class PermissionController extends BaseRestController{

    @Autowired
    private PermissionService permissionService;

    /*
    * @Description:这个方法是添加权限资源
    * @Param:permission
    * */
    @PostMapping
    @ResponseBody
    //@RequiresPermissions("permission:add")
    public RestResponse save(@RequestBody Permission permission) {
        boolean permissionAfter = permissionService.save(permission);
        if(permissionAfter){
            return success("操作成功");
        }
        return fail("操作失败","01",0,null);

    }

    /*
    * @Description:这个是删除相应的权限的操作
    * @Param:idd(int)
    * */
    @DeleteMapping("/{id}")
    @ResponseBody
    @RequiresPermissions("permission:delete")
    public RestResponse delete(@PathVariable("id") int id){
        Boolean result = permissionService.deleteById(id);
        if(result){
            return success("操作成功");
        }
        return fail("操作失败","01",0,null);
    }

    /*
    * @Description:这个是负责修改权限信息的操作
    * @Param:Permission
    * */
    @PutMapping
    @ResponseBody
    @RequiresPermissions("permission:update")
    public RestResponse update(@RequestBody Permission permission){

        return success("操作成功");
    }

    /*
    * @Description:这个是查询出所有的权限信息，用来添加角色的时候选择分配权限
    * @Return:List
    * */
    //@RequiresPermissions("permission:list")
    @GetMapping
    @ResponseBody
    public RestResponse<List<Permission>> permissions(){
        System.out.println("所有权限");
        List<Permission> permissions = permissionService.Permissions();
        String message = "高校基层管理系统";
        int count = permissions.size();
        return success("请求成功","0",count,permissions);
        //return success(permissions);
    }

    @RequestMapping("/list")
    public String permissionPage(){
        return "permission/perm";
    }
    @RequestMapping("/add")
    public String permissionAddPage(){
        return "permission/add";
    }



    /*
    * @Description:根据角色获取相应的权限,提供给Shiro
    * @Param:Role(class)
    * */
    public RestResponse<List<Permission>> findPermissionByRole(List<Role> role){
        List<Permission> permissions  = permissionService.permissionsByRole(role);
        return success(permissions);
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

    @GetMapping("/perm")
    @ResponseBody
    public RestResponse<List<Permission>> getPermissionListToAdd(){
        System.out.println("查询菜单中...");
        List<Permission> menuList = permissionService.getPermission();
        int count = menuList.size();
        return success("请求成功","0",count,menuList);
    }


}
