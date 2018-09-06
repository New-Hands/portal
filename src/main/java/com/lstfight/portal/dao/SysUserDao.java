package com.lstfight.portal.dao;

import com.lstfight.dao.dao.BaseDao;
import com.lstfight.portal.entity.SysUserEntity;
import com.lstfight.portal.model.PageBean;

import java.io.Serializable;
import java.util.List;

/**
 * @author 李尚庭
 */
public interface SysUserDao extends BaseDao<SysUserEntity,Serializable> {

    /**
     * 根据用户名获取用户信息
     *
     * @param userName 用户名
     * @return 系统用户实体
     */
    SysUserEntity findFirstByUserName(String userName);

    /**
     * 根据用户类型获取用户
     *
     * @param userType 用户类型
     * @return 用户实体
     */
    SysUserEntity findFirstByUserType(byte userType);

    /**
     * 根据用户名查询用户实体
     *
     * @param userName 用户名
     * @return
     */
    SysUserEntity findSysUserEntityByUserName(String userName);

}
