package com.lstfight.portal.entity;

import com.lstfight.dao.entity.BaseEntity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author 李尚庭
 * @date 2018/8/8 0008 9:34
 */
@Entity
@Table(name = "sys_resource_role", schema = "portal")
public class SysResourceRoleEntity extends BaseEntity {
    private String resourceRoleId;
    private String resourceValue;
    private String roleName;
    private int resourceRoleStatus;

    @Column(name = "resource_value")
    public String getResourceValue() {
        return resourceValue;
    }

    public void setResourceValue(String resourceValue) {
        this.resourceValue = resourceValue;
    }

    @Column(name = "role_name")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Id
    @Column(name = "resource_role_id", nullable = false, length = 32)
    public String getResourceRoleId() {
        return resourceRoleId;
    }

    public void setResourceRoleId(String resourceRoleId) {
        this.resourceRoleId = resourceRoleId;
    }

    @Basic
    @Column(name = "resource_role_status", nullable = false)
    public int getResourceRoleStatus() {
        return resourceRoleStatus;
    }

    public void setResourceRoleStatus(int resourceRoleStatus) {
        this.resourceRoleStatus = resourceRoleStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SysResourceRoleEntity that = (SysResourceRoleEntity) o;
        return resourceRoleStatus == that.resourceRoleStatus &&
                Objects.equals(resourceRoleId, that.resourceRoleId) &&
                Objects.equals(resourceValue, that.resourceValue) &&
                Objects.equals(roleName, that.roleName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(resourceRoleId, resourceValue, roleName, resourceRoleStatus);
    }
}
