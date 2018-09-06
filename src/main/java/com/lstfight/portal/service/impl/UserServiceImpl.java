package com.lstfight.portal.service.impl;

import com.lstfight.portal.dao.SysUserDao;
import com.lstfight.portal.entity.SysUserEntity;
import com.lstfight.portal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李尚庭
 * @date 2018/8/14 0014 10:25
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    SysUserDao sysUserDao;

    @Override
    public SysUserEntity createUser(SysUserEntity userEntity) {
        return null;
    }

    @Override
    public SysUserEntity updateUser(SysUserEntity userEntity) {
        return null;
    }

    @Override
    public List<SysUserEntity> getUserListByUserId(String userId) {
        StringBuilder sql = new StringBuilder();
        sql.append(" select user_id,user_name, user_status, user_type from sys_user u, department_user d where d.user_id = u.user_id");
        sql.append(" and d.department_id in (:departmentIdList)");
        Map<String, Object> param = new HashMap<>(16);
        param.put("departmentIdList", param);
        return sysUserDao.queryListBySql(sql.toString(), param, SysUserEntity.class);
    }

    @Override
    public String getUserIdByUserName(String userName) {
        SysUserEntity user = sysUserDao.findFirstByUserName(userName);
        if (user != null) {
            return user.getUserId();
        }
        return null;
    }
}
