package com.lstfight.portal.dao;

import com.lstfight.dao.dao.BaseDao;
import com.lstfight.portal.entity.SysUserRoleEntity;

import java.io.Serializable;
import java.util.List;

/**
 * @author 李尚庭
 *
 */
public interface SysUserRoleDao extends BaseDao<SysUserRoleEntity,Serializable> {
    /**
     *
     * @param userName 用户名
     * @return
     */
    List<SysUserRoleEntity> findAllByUserName(String userName);

    /**
     * 查找角色关系
     *
     * @param userName 用户名
     * @param roleName 角色名
     * @return
     */
    SysUserRoleEntity findALLByUserNameAndRoleName(String userName,String roleName);

}
