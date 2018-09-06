package com.lstfight.portal.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author 李尚庭
 * @date 2018/8/22 0022 8:51 
 */
public class DepartmentUserEntityPK implements Serializable {
    private String departmentId;
    private String userId;

    @Column(name = "department_id", nullable = false, length = 32)
    @Id
    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    @Column(name = "user_id", nullable = false, length = 32)
    @Id
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentUserEntityPK that = (DepartmentUserEntityPK) o;
        return Objects.equals(departmentId, that.departmentId) &&
                Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(departmentId, userId);
    }
}
