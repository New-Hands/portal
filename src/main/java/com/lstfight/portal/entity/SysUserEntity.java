package com.lstfight.portal.entity;

import com.lstfight.dao.entity.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * @date 2018/8/6 0006 18:18
 * @author 李尚庭
 */
@Entity
@Table(name = "sys_user", schema = "portal" )
public class SysUserEntity extends BaseEntity {
    private String userId;
    private String userName;
    private String userLoginId;
    private String userPasswd;
    private Byte userStatus;
    private Byte userType;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(
            name = "uuid",
            strategy = "org.hibernate.id.UUIDHexGenerator"
    )
    @Column(name = "user_id", length = 32)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_login_id")
    public String getUserLoginId() {
        return userLoginId;
    }

    public void setUserLoginId(String userLoginId) {
        this.userLoginId = userLoginId;
    }

    @Basic
    @Column(name = "user_passwd")
    public String getUserPasswd() {
        return userPasswd;
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }

    @Basic
    @Column(name = "user_status")
    public Byte getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Byte userStatus) {
        this.userStatus = userStatus;
    }

    @Basic
    @Column(name = "user_type")
    public Byte getUserType() {
        return userType;
    }

    public void setUserType(Byte userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SysUserEntity that = (SysUserEntity) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(userLoginId, that.userLoginId) &&
                Objects.equals(userPasswd, that.userPasswd) &&
                Objects.equals(userStatus, that.userStatus) &&
                Objects.equals(userType, that.userType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, userLoginId, userPasswd, userStatus, userType);
    }

    @Override
    public String toString() {
        return "SysUserEntity{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userLoginId='" + userLoginId + '\'' +
                ", userPasswd='" + userPasswd + '\'' +
                ", userStatus=" + userStatus +
                ", userType=" + userType +
                '}';
    }
}
