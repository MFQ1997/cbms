package com.gdupt.cbms.entity.shiro;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.List;

/*
* @Name:Role
* @Description:这个是整合shiro权限框架的Role实体类
* @Date:2019
* */

public class Role {

	@TableId(type= IdType.AUTO)
	private Integer id;			//自增长的主键id
	private String roleName;	//角色的名字
	private int status;			//角色的状态
	private String remark;		//角色的备注

	/*
	* @Description:这个是角色对应的权限的集合
	* @Type:set
	* */
	private List<Permission> permissions;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	@Override
	public String toString() {
		return "Role{" +
				"id=" + id +
				", roleName='" + roleName + '\'' +
				", status=" + status +
				", remark='" + remark + '\'' +
				", permissions=" + permissions +
				'}';
	}
}