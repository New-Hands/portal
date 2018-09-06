package com.lstfight.portal.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lstfight.dao.entity.BaseEntity;
import com.lstfight.systemutil.treeutil.Tree;
import javax.persistence.*;
import java.util.Objects;

/**
 * @date 2018/8/7 0007 15:56
 * @author 李尚庭
 */
@Entity
@Table(name = "sys_resource", schema = "portal")
public class SysResourceEntity extends BaseEntity implements Tree {
    @Id
    @Column(name = "resource_id", nullable = false, length = 32)
    private String resourceId;
    @Column(name = "resource_parent_id", nullable = true, length = 32)
    private String resourceParentId;
    @Column(name = "resource_name", nullable = true, length = 32)
    private String resourceName;
    @Column(name = "resource_code", nullable = true, length = 60)
    private String resourceCode;
    @Column(name = "resource_type", nullable = false)
    private int resourceType;
    @Column(name = "resource_value", nullable = false, length = 60)
    private String resourceValue;
    @Column(name = "resource_status", nullable = true)
    private int resourceStatus;

    public void setResourceStatus(Integer resourceStatus) {
        this.resourceStatus = resourceStatus;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceParentId() {
        return resourceParentId;
    }

    public void setResourceParentId(String resourceParentId) {
        this.resourceParentId = resourceParentId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }


    public int getResourceType() {
        return resourceType;
    }

    public void setResourceType(int resourceType) {
        this.resourceType = resourceType;
    }


    public String getResourceValue() {
        return resourceValue;
    }

    public void setResourceValue(String resourceValue) {
        this.resourceValue = resourceValue;
    }


    public int getResourceStatus() {
        return resourceStatus;
    }

    public void setResourceStatus(int resourceStatus) {
        this.resourceStatus = resourceStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        SysResourceEntity that = (SysResourceEntity) o;
        return resourceType == that.resourceType &&
                resourceStatus == that.resourceStatus &&
                Objects.equals(resourceId, that.resourceId) &&
                Objects.equals(resourceParentId, that.resourceParentId) &&
                Objects.equals(resourceName, that.resourceName) &&
                Objects.equals(resourceCode, that.resourceCode) &&
                Objects.equals(resourceValue, that.resourceValue);
    }


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), resourceId, resourceParentId, resourceName, resourceCode, resourceType, resourceValue, resourceStatus);
    }

    /**
     * 不序列化该方法数据
     * @return
     */
    @JsonIgnore
    @Override
    public String getParentId() {
        return this.resourceParentId;
    }

    @JsonIgnore
    @Override
    public String getNodeId() {
        return this.resourceId;
    }
}
