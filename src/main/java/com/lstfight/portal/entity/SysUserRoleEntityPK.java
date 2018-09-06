package com.lstfight.portal.entity;

import com.lstfight.dao.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author 李尚庭
 * @date 2018/8/22 0022 8:52
 */
public class SysUserRoleEntityPK extends BaseEntity implements Serializable {
    private String roleName;
    private String userName;

    @Column(name = "role_name")
    @Id
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Column(name = "user_name")
    @Id
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysUserRoleEntityPK that = (SysUserRoleEntityPK) o;
        return Objects.equals(roleName, that.roleName) &&
                Objects.equals(userName, that.userName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(roleName, userName);
    }
}
