package com.lstfight.portal.dao;

import com.lstfight.dao.dao.BaseDao;
import com.lstfight.portal.entity.SysResourceRoleEntity;

import java.io.Serializable;
import java.util.List;

/**
 * @date 2018/8/8 0008 8:54
 * @author 李尚庭
 */
public interface SysResourceRoleDao extends BaseDao<SysResourceRoleEntity,Serializable> {
    /**
     * 根据资源值获取角色
     *
     * @param resourceValue 资源值
     * @return 资源角色实体
     */
    List<SysResourceRoleEntity> findAllByResourceValue(String resourceValue);

    /**
     * 根据角色名获取资源角色
     *
     * @param roleName 角色名
     * @return 资源角色实体
     */
    List<SysResourceRoleEntity> findAllByRoleName(String roleName);
}
