package com.lstfight.portal.service;

import com.lstfight.portal.entity.SysUserEntity;

import java.util.List;

/**
 * @author 李尚庭
 * @date 2018/8/14 0014 10:24
 */
public interface UserService {

    /**
     * 新增一个用户
     *
     * @param userEntity 用户实体
     * @return 新增用户
     */
    SysUserEntity createUser(SysUserEntity userEntity);

    /**
     * 修改用户
     *
     * @param userEntity 用户实体
     * @return 修改用户实体
     */
    SysUserEntity updateUser(SysUserEntity userEntity);

    /**
     * 获取用户所辖用户列表
     * <p>请合理使用<p/>
     *
     * @param userId 用户id
     * @return 下级用户列表
     */
    List<SysUserEntity> getUserListByUserId(String userId);

    /**
     * <p>根据用户名获取用户id</p>
     *
     * @param userName 用户名
     * @return 用户id
     */
    String getUserIdByUserName(String userName);
}
