package com.lstfight.portal.config;


import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * 实现Servlet定义接口
 * Servlet负责调用
 * 指定DispatchServlet处理请求
 * @date 2018/7/31 0031 9:00
 * @author 李尚庭
 */
public class WebAppInitializerImpl extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new CharacterEncodingFilter("utf-8",true,true),new HiddenHttpMethodFilter()};
    }

}
