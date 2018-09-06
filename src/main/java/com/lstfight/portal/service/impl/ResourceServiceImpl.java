package com.lstfight.portal.service.impl;

import com.lstfight.dao.service.BaseServerImpl;

import com.lstfight.portal.constant.DatabaseConstant;
import com.lstfight.portal.dao.SysResourceDao;
import com.lstfight.portal.dao.SysResourceRoleDao;
import com.lstfight.portal.entity.SysResourceEntity;
import com.lstfight.portal.entity.SysResourceRoleEntity;
import com.lstfight.portal.service.ResourceService;
import com.lstfight.portal.systemprovider.SystemUserInfoProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李尚庭
 * @date 2018/8/15 0015 16:41
 *
 */
@Service
public class ResourceServiceImpl extends BaseServerImpl<SysResourceEntity,Serializable> implements ResourceService {

    @Autowired
    SystemUserInfoProvider systemUserInfoProvider;

    @Autowired
    SysResourceDao resourceDao;

    @Autowired
    SysResourceRoleDao sysResourceRoleDao;

    @Override
    public List<SysResourceEntity> getResourceTree() {
        //当前用户角色
        List<String> roles =systemUserInfoProvider.getUserRoles();

        StringBuilder sql = new StringBuilder();
        Map<String, Object> param = new HashMap<>(16);
        sql.append(" select resource_id, resource_parent_id, resource_name ,resource_code, resource_type, resource_value, resource_status from sys_resource where resource_value in");
        sql.append(" (select distinct resource_value from sys_resource_role where role_name in(:roles))");
        sql.append(" and resource_type = :resourceType");
        param.put("roles", roles);
        param.put("resourceType", DatabaseConstant.ResourceType.MENU.getType());
        return resourceDao.queryListBySql(sql.toString(), param, SysResourceEntity.class);
    }

    @Override
    public List<SysResourceEntity> getAllResource() {
        StringBuilder sql = new StringBuilder();
        Map<String, Object> param = new HashMap<>(16);
        sql.append(" select resource_id, resource_parent_id, resource_name ,resource_code, resource_type, resource_value, resource_status from sys_resource");

        return resourceDao.queryListBySql(sql.toString(), param, SysResourceEntity.class);
    }

    @Override
    public void grantResourceToRoleByRoleName(List<String> resources, String roleName) {
        //生产资源角色关系
        for (String resourceValue : resources) {
            SysResourceRoleEntity resourceRoleEntity = new SysResourceRoleEntity();
            resourceRoleEntity.setResourceValue(resourceValue);
            resourceRoleEntity.setRoleName(roleName);
            sysResourceRoleDao.save(resourceRoleEntity);
        }
    }

    @Override
    public void copyRoleResourceRoToRole(String sourceRoleName, String targetRoleName) {

    }
}
