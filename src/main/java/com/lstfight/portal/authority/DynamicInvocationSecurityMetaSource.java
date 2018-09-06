package com.lstfight.portal.authority;

import com.lstfight.portal.dao.SysResourceRoleDao;
import com.lstfight.portal.dao.SysRoleDao;
import com.lstfight.portal.entity.SysResourceRoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 获取到当前请求资源所需权限角色
 *
 * @author 李尚庭
 * @date 2018/8/7 0007 14:26
 */
@Component
public class DynamicInvocationSecurityMetaSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    SysResourceRoleDao sysResourceRoleDao;

    @Autowired
    SysRoleDao roleDao;

    /**
     * 配置请求的url可以被哪些角色访问
     *
     * @param object FilterInvocation对象
     * @return 可访问对象
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        List<SysResourceRoleEntity> resourceRoleEntities = sysResourceRoleDao.findAllByResourceValue(requestUrl);
        Collection<ConfigAttribute> configAttributes = new ArrayList<>();
        for (SysResourceRoleEntity resourceRoleEntity : resourceRoleEntities) {
            configAttributes.add(resourceRoleEntity::getRoleName);
        }
        return configAttributes;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
