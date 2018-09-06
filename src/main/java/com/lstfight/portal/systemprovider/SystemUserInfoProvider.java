package com.lstfight.portal.systemprovider;

import com.lstfight.portal.entity.SysResourceEntity;
import com.lstfight.portal.entity.SysUserEntity;

import java.util.List;

/**
 * <p>提供便于获取等于用户信息</p>
 *
 * @author 李尚庭
 * @date 2018/8/15 0015 14:02
 */
public interface SystemUserInfoProvider {

    List<String> getUserRoles();

    List<SysResourceEntity> getUserResource();

    /**
     *
     * @return
     */
    SysUserEntity getUser();

    String getUserName();

    /**
     * 获取用户可管理部门id
     *
     * @return 用户可管理部门id列表
     */
    List<String> getDepartmentIdList();

    /**
     * 获取子部门id
     *
     * @return
     */
    List<String> getChildDepartmentId();

}
