package com.lstfight.portal.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "department_user", schema = "portal", catalog = "")
@IdClass(DepartmentUserEntityPK.class)
public class DepartmentUserEntity {
    private String departmentId;
    private String userId;
    private Integer status;

    @Id
    @Column(name = "department_id", nullable = false, length = 32)
    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    @Id
    @Column(name = "user_id", nullable = false, length = 32)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "status", nullable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentUserEntity that = (DepartmentUserEntity) o;
        return Objects.equals(departmentId, that.departmentId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(departmentId, userId, status);
    }
}
