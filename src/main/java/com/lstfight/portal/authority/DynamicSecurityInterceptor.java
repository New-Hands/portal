package com.lstfight.portal.authority;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * 自定义授权拦截器
 *
 * <p>{@link DynamicInvocationSecurityMetaSource 获取所需权限}</p>
 * <p>{@link DynamicAccessDecisionManager 根据所需权限判定用户权限是否满足及是否放行}</p>
 *
 * @author 李尚庭
 * @date 2018/8/8 0008 10:31
 */
@Component
public class DynamicSecurityInterceptor extends AbstractSecurityInterceptor implements Filter {

    @Autowired
    DynamicInvocationSecurityMetaSource dynamicInvocationSecurityMetaSource;

    public DynamicSecurityInterceptor() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        FilterInvocation filterInvocation = new FilterInvocation(servletRequest, servletResponse, filterChain);
        this.invoke(filterInvocation);
    }

    public void invoke(FilterInvocation fi) throws IOException, ServletException {

        InterceptorStatusToken token = super.beforeInvocation(fi);

        try {
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
        } finally {
            super.finallyInvocation(token);
        }

        super.afterInvocation(token, null);
    }

    @Override
    public Class<?> getSecureObjectClass() {
        return FilterInvocation.class;
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return this.dynamicInvocationSecurityMetaSource;
    }

    @Autowired
    @Override
    public void setAccessDecisionManager(AccessDecisionManager accessDecisionManager) {
        super.setAccessDecisionManager(accessDecisionManager);
    }
}
