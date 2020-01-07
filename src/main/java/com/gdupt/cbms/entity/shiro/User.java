package com.gdupt.cbms.entity.shiro;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/*
* @Name:User
* @Description:这个是整合shiro权限框架的用户实体类
* @Date:2019
* */

public class User {

    /*
    * @Description:这个是user表的信息
    * */
    @TableId(type= IdType.AUTO)
    private Integer id;         //自增长的主键id
    @NotNull
    private String userName;    //账号
    @NotNull
    private String password;    //密码
    private String salt;        //盐值
    private int status;         //状态

    /*
    * @Description:这个是userInfo表的信息
    * */
    private String realName;    //真实名字
    private String photo;       //用户的头像
    private String selfNum;     //身份证信息
    private String phone;       //电话
    private String email;       //邮箱
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;    //完善时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;    //更新时间
    private Integer companyId;  //公司id
    private String remark;      //备注

    /*
    * @Description:这个是用户对应的角色的集合
    * @Type:set
    * */
    @TableField(exist = false)
    private List<Role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSelfNum() {
        return selfNum;
    }

    public void setSelfNum(String selfNum) {
        this.selfNum = selfNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", status=" + status +
                ", realName='" + realName + '\'' +
                ", photo='" + photo + '\'' +
                ", selfNum='" + selfNum + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", companyId=" + companyId +
                ", remark='" + remark + '\'' +
                ", roles=" + roles +
                '}';
    }
}
