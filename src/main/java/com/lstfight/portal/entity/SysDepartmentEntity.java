package com.lstfight.portal.entity;

import com.lstfight.dao.entity.BaseEntity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author 李尚庭
 * @date 2018/8/15 0015 10:27
 */
@Entity
@Table(name = "sys_department", schema = "portal")
public class SysDepartmentEntity extends BaseEntity {
    private String departmentId;
    private String departmentName;
    private String departmentCode;
    private String departmentParentId;
    private String departmentRoleId;
    private Integer departmentStatus;

    @Id
    @Column(name = "department_id", nullable = false, length = 32)
    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    @Basic
    @Column(name = "department_name", nullable = true, length = 60)
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Basic
    @Column(name = "department_code", nullable = true, length = 60)
    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    @Basic
    @Column(name = "department_parent_id", nullable = true, length = 32)
    public String getDepartmentParentId() {
        return departmentParentId;
    }

    public void setDepartmentParentId(String departmentParentId) {
        this.departmentParentId = departmentParentId;
    }

    @Column(name = "department_role_id", length = 32)
    public String getDepartmentRoleId() {
        return departmentRoleId;
    }

    public void setDepartmentRoleId(String departmentRoleId) {
        this.departmentRoleId = departmentRoleId;
    }

    @Basic
    @Column(name = "department_status", nullable = true)
    public Integer getDepartmentStatus() {
        return departmentStatus;
    }

    public void setDepartmentStatus(Integer departmentStatus) {
        this.departmentStatus = departmentStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SysDepartmentEntity that = (SysDepartmentEntity) o;
        return Objects.equals(departmentId, that.departmentId) &&
                Objects.equals(departmentName, that.departmentName) &&
                Objects.equals(departmentCode, that.departmentCode) &&
                Objects.equals(departmentParentId, that.departmentParentId) &&
                Objects.equals(departmentRoleId, that.departmentRoleId) &&
                Objects.equals(departmentStatus, that.departmentStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentId, departmentName, departmentCode, departmentParentId, departmentRoleId, departmentStatus);
    }
}




