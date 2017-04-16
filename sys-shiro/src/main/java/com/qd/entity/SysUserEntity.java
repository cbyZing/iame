package com.qd.entity;

import com.qd.validator.group.AddGroup;
import com.qd.validator.group.UpdateGroup;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by chenlongbo on 2017/4/16.
 * 系统用户
 */
@Entity
@Table(schema = "ideado",name = "sys_user")
public class SysUserEntity implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long userId;

    /**
     * 用户名
     */
    @Column(name="username")
    @NotBlank(message="用户名不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String username;

    /**
     * 密码
     */
    @Column(name="password")
    @NotBlank(message="密码不能为空", groups = AddGroup.class)
    private  String password;

    /**
     * 邮箱
     */
    @Column(name="email")
    @NotBlank(message="邮箱不能为空", groups = {AddGroup.class, UpdateGroup.class})
    @Email(message="邮箱格式不正确", groups = {AddGroup.class, UpdateGroup.class})
    private String email;

    /**
     * 手机号
     */
    @Column(name="mobile")
    private String mobile;

    /**
     * 状态  0：禁用   1：正常
     */
    @Column(name="status")
    private Integer status;

    /**
     * 角色ID列表
     */
    @Transient
    private List<Long> roleIdList;

    /**
     * 创建者ID
     */
    @Column(name="create_user_id")
    private Long createUserId;

    /**
     * 创建时间
     */
    @Column(name="create_time")
    private Date createTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Long> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<Long> roleIdList) {
        this.roleIdList = roleIdList;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
