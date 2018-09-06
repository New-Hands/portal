package com.lstfight.portal.dao;

import com.lstfight.dao.dao.BaseDao;
import com.lstfight.portal.entity.SysRoleEntity;

import java.io.Serializable;

/**
 * @author 李尚庭
 */
public interface SysRoleDao extends BaseDao<SysRoleEntity, Serializable> {
    /**
     * 根据角色名获取角色实体
     *
     * @param roleName 角色名
     * @return 角色实体
     */
    SysRoleEntity findFirstByRoleName(String roleName);

    /**
     * 根据角色排序获取角色实体
     *
     * @param roleOrder 角色排序
     * @return 角色实体
     */
    SysRoleEntity findFirstByRoleType(int roleOrder);

    /**
     * 根据角色类型获取角色实体
     * @param roleType 角色类型
     * @return 角色实体
     */
    SysRoleEntity findFirstByRoleType(byte roleType);

}
