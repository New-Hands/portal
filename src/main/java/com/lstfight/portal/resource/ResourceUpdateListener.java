package com.lstfight.portal.resource;

import com.lstfight.portal.dao.*;
import com.lstfight.portal.entity.SysResourceEntity;
import com.lstfight.portal.entity.SysRoleEntity;
import com.lstfight.portal.entity.SysUserEntity;
import com.lstfight.portal.entity.SysUserRoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


/**
 * @author 李尚庭
 * 系统初始化工作
 * 用户 -》 用户角色
 * 资源 -》 资源角色
 * 更新存储标记权限
 * @date 2018/8/6 0006 16:36
 */
@Component
public class ResourceUpdateListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    ResourcePostScan authorityPostScan;

    @Autowired
    SysResourceDao sysResourceDao;

    @Autowired
    SysRoleDao sysRoleDao;

    @Autowired
    SysUserDao sysUserDao;

    @Autowired
    SysUserRoleDao sysUserRoleDao;

    @Autowired
    SysResourceRoleDao sysResourceRoleDao;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (null == event.getApplicationContext().getParent()) {
            //系统角色 0为系统用户类型
            SysRoleEntity roleEntity = sysRoleDao.findFirstByRoleType((byte) 0);
            if (roleEntity == null) {
                SysRoleEntity newRoleEntity = new SysRoleEntity();
                newRoleEntity.setRoleName("admin");
                newRoleEntity.setRoleType((byte) 0);
                newRoleEntity.setRoleDefineType((byte) 0);
                newRoleEntity.setRoleStatus((byte) 1);
                newRoleEntity.setRoleBelongSystem("/portal");
                roleEntity = sysRoleDao.save(newRoleEntity);
            }

            //新建系统用户
            SysUserEntity userEntity = sysUserDao.findFirstByUserType((byte) 0);
            if (userEntity == null) {
                SysUserEntity newUserEntity = new SysUserEntity();
                newUserEntity.setUserName("admin");
                newUserEntity.setUserPasswd("123456");
                newUserEntity.setUserType((byte) 0);
                newUserEntity.setUserStatus((byte) 1);
                userEntity = sysUserDao.save(newUserEntity);
            }

            SysUserRoleEntity userRoleEntity = sysUserRoleDao.findALLByUserNameAndRoleName("admin", "admin");
            if (userRoleEntity == null) {
                //新建用户角色 判读 重复存入会回滚
                sysUserRoleDao.save(new SysUserRoleEntity(roleEntity.getRoleName(), userEntity.getUserName(), (byte) 1));
            }

            //新建资源
            sysResourceDao.deleteAll();

            authorityPostScan.resourceEntities.forEach(entity -> sysResourceDao.save(entity));
            // sysResourceDao.save(authorityPostScan.resourceEntities.get(1));
        }
    }
}
