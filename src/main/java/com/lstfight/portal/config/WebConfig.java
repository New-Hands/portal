package com.lstfight.portal.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @author 李尚庭
 * @date 2018/7/31 0031 9:00
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.lstfight.*")
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * 配置view解析器
     *
     * @param registry viewResolver注册器
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.enableContentNegotiation(new MappingJackson2JsonView());
        registry.jsp();
    }


    /**
     * 接收Request 在dispatchServlet之前使用defaultServlet处理静态资源请求
     * 可以使用resourceHandler解决静态资源访问问题
     *
     * @param configurer 默认Servlet配置
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable("default");
    }

    /**
     * 配置消息转换 资源表述的转换
     * 当使用@Responsebody后生效
     *
     * @param converters 消息转换器
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MappingJackson2HttpMessageConverter());
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
        stringHttpMessageConverter.setDefaultCharset(Charset.forName("utf-8"));
        converters.add(stringHttpMessageConverter);
    }

    /**
     * 对跨域请求的支持
     * 配置时使用registry进行addMapping
     * 也可以使用过滤器的方式进行跨域支持的添加
     *
     * @param registry 注册器
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {

    }


    /**
     * 配置拦截器可以对请求进行拦截
     *
     */

    /**
     *  配置请求内容匹配解析器
     */

}
