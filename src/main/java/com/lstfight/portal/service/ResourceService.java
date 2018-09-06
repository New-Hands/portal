package com.lstfight.portal.service;

import com.lstfight.dao.service.BaseService;
import com.lstfight.portal.entity.SysResourceEntity;

import java.io.Serializable;
import java.util.List;

/**
 * @author 李尚庭
 * @date 2018/8/15 0015 16:39
 */
public interface ResourceService extends BaseService<SysResourceEntity, Serializable> {

    /**
     * 查询当前用户可用资源
     *
     * @return 当前用户可用菜单资源
     */
    List<SysResourceEntity> getResourceTree();

    /**
     * 获取所有资源
     *
     * @return
     */
    List<SysResourceEntity> getAllResource();

    /**
     * 将资源授权给角色
     *
     * @param roleName 角色名
     */
    void grantResourceToRoleByRoleName(List<String> resources, String roleName);

    /**
     * 将指定角色权限拷贝给另一个用户
     *
     * @param sourceRoleName 源角色名
     * @param targetRoleName 目标角色名
     */
    void copyRoleResourceRoToRole(String sourceRoleName, String targetRoleName);
}
