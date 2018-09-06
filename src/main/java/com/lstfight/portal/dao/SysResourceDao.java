package com.lstfight.portal.dao;

import com.lstfight.dao.dao.BaseDao;
import com.lstfight.portal.entity.SysResourceEntity;

import java.io.Serializable;
import java.util.List;

/**
 * 系统接口资源DAO接口
 *
 * @date 2018/8/7 0007 18:24
 * @author 李尚庭
 */
public interface SysResourceDao extends BaseDao<SysResourceEntity, Serializable> {

    /**
     * 根据parentId查询资源
     *
     * @param parentId 资源parentId
     * @return 资源list
     */
    List<SysResourceEntity> getAllByResourceParentId(String parentId);

    /**
     * 根据资源类型获取资源
     *
     * @param resourceType 资源类型
     * @return 资源列表
     */
    List<SysResourceEntity> getAllByResourceType(int resourceType);


}
