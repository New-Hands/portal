package com.lstfight.portal.entity;

import com.lstfight.dao.entity.BaseEntity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @date 2018/8/6 0006 10:36 
 * @author 李尚庭
 */
@Entity
@Table(name = "sys_user_role", schema = "portal")
@IdClass(SysUserRoleEntityPK.class)
public class SysUserRoleEntity extends BaseEntity {
    private String roleName;
    private String userName;
    private Byte userRoleStatus;

    public SysUserRoleEntity() {
    }

    public SysUserRoleEntity(String roleName, String userName, Byte userRoleStatus) {
        this.roleName = roleName;
        this.userName = userName;
        this.userRoleStatus = userRoleStatus;
    }

    @Id
    @Column(name = "role_name")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Id
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_role_status")
    public Byte getUserRoleStatus() {
        return userRoleStatus;
    }

    public void setUserRoleStatus(Byte userRoleStatus) {
        this.userRoleStatus = userRoleStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysUserRoleEntity that = (SysUserRoleEntity) o;
        return Objects.equals(roleName, that.roleName) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(userRoleStatus, that.userRoleStatus);
    }

    @Override
    public int hashCode() {

        return Objects.hash(roleName, userName, userRoleStatus);
    }
}
