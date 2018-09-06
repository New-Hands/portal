package com.lstfight.portal.systemprovider;

import com.lstfight.portal.entity.SysResourceEntity;
import com.lstfight.portal.entity.SysUserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 获取用户详细信息
 * 问题1：静态方法不能实现接口
 * @author 李尚庭
 * @date 2018/8/15 0015 10:33
 */
@Component
public class SystemUserInfo implements SystemUserInfoProvider{
    //不能使用自动获取的方式注入依赖

    @Override
    public List<String> getUserRoles() {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
    }

    @Override
    public List<SysResourceEntity> getUserResource() {
        return null;
    }

    @Override
    public SysUserEntity getUser() {
        return null;
    }

    @Override
    public List<String> getDepartmentIdList() {

        return null;
    }

    @Override
    public List<String> getChildDepartmentId() {
        return null;
    }


    @Override
    public String getUserName() {
        return ((UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
    }
}
