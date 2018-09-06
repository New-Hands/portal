package com.lstfight.portal.entity;

import com.lstfight.dao.entity.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * @date 2018/8/8 0008 9:30
 * @author 李尚庭
 */
@Entity
@Table(name = "sys_role", schema = "portal", catalog = "")
public class SysRoleEntity extends BaseEntity {
    private String roleId;
    private String roleName;
    private byte roleType;
    private byte roleDefineType;
    private String roleBelongSystem;
    private String roleDescription;
    private Byte roleStatus;
    private Integer roleOrder;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(
            name = "uuid",
            strategy = "org.hibernate.id.UUIDHexGenerator"
    )
    @Column(name = "role_id", nullable = false, length = 32)
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "role_name", nullable = false, length = 32)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "role_type", nullable = false)
    public byte getRoleType() {
        return roleType;
    }

    public void setRoleType(byte roleType) {
        this.roleType = roleType;
    }

    @Basic
    @Column(name = "role_define_type", nullable = false)
    public byte getRoleDefineType() {
        return roleDefineType;
    }

    public void setRoleDefineType(byte roleDefineType) {
        this.roleDefineType = roleDefineType;
    }

    @Basic
    @Column(name = "role_belong_system", nullable = false, length = 50)
    public String getRoleBelongSystem() {
        return roleBelongSystem;
    }

    public void setRoleBelongSystem(String roleBelongSystem) {
        this.roleBelongSystem = roleBelongSystem;
    }

    @Basic
    @Column(name = "role_description", nullable = true, length = 255)
    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    @Basic
    @Column(name = "role_status", nullable = true)
    public Byte getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(Byte roleStatus) {
        this.roleStatus = roleStatus;
    }

    @Basic
    @Column(name = "role_order", nullable = true)
    public Integer getRoleOrder() {
        return roleOrder;
    }

    public void setRoleOrder(Integer roleOrder) {
        this.roleOrder = roleOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SysRoleEntity that = (SysRoleEntity) o;
        return roleType == that.roleType &&
                roleDefineType == that.roleDefineType &&
                Objects.equals(roleId, that.roleId) &&
                Objects.equals(roleName, that.roleName) &&
                Objects.equals(roleBelongSystem, that.roleBelongSystem) &&
                Objects.equals(roleDescription, that.roleDescription) &&
                Objects.equals(roleStatus, that.roleStatus) &&
                Objects.equals(roleOrder, that.roleOrder);
    }

    @Override
    public int hashCode() {

        return Objects.hash(roleId, roleName, roleType, roleDefineType, roleBelongSystem, roleDescription, roleStatus, roleOrder);
    }
}
