package com.gdupt.cbms.entity.shiro;

/*
* @Name:Permission
* @Description:这个是整合shiro权限框架的权限实体类
* @Date：2019
* */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.List;

public class Permission {

    @TableId(type= IdType.AUTO)
    private Integer id;     //自增长的主键id
    private int pid;        //父Id
    private String permissionName;    //权限的名称
    private String url;     //权限对应的URL
    private String icon;    //icon小图标
    private String status;  //权限的状态
    private int sort;       //权限的排序
    private String type;    //权限的类型
    private String perms;   //权限的标识
    private String remark;  //备注信息

    //获取子元素
    private List<Permission> children;

    public List<Permission> getChildren() {
        return children;
    }

    public void setChildren(List<Permission> children) {
        this.children = children;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", pid=" + pid +
                ", permissionName='" + permissionName + '\'' +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                ", status='" + status + '\'' +
                ", sort=" + sort +
                ", type='" + type + '\'' +
                ", perms='" + perms + '\'' +
                ", remark='" + remark + '\'' +
                ", children=" + children +
                '}';
    }
}