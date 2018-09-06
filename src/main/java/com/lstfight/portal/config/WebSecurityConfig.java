package com.lstfight.portal.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.lstfight.portal.authentication.DbUserDetailServiceImpl;
import com.lstfight.portal.authority.DynamicSecurityInterceptor;
import com.lstfight.portal.model.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;


/**
 * @author 李尚庭
 * @date 2018/8/3 0003 11:09
 * 配置认证策略和认证数据源
 * 还可以配置基于方法安全的认证 使用
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DynamicSecurityInterceptor dynamicSecurityInterceptor;

    /**
     * 在这里相当于是硬性的配置
     * 对http协议实现进行配置
     * 指定需要认证的策略
     * 同时可以登录界面
     * 可以使用path variable 获取参数
     * has role 指定可访问角色
     * 可以通过WebSecurityConfigurerAdapter 实现多个认证模块 并使用@Order指定顺序
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * hasRole 与 hasAuthority {有无role前缀的区别}
         */
        http
                .authorizeRequests()
                //静态资源脚本图标不拦截 公共静态资源
                .antMatchers("/libs/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                //前后端分离后可以不使用loginPage
                //解决拦截静态文件后返回静态文件内容/错误页面重定向 适合前后端分离架构
                .successHandler((request, response, authentication) -> response.setStatus(200))
                .failureHandler((request, response, exception) -> {
                    response.setStatus(401);
                    ObjectMapper objectMapper = new ObjectMapper();
                    String res = objectMapper.writeValueAsString(ResultBean.fluent().addFlag(false).addMessage(exception.getMessage()));
                    response.getWriter().write(res);
                })
                .permitAll();

        /**
         * logoutHandler 的配置
         * 在登出后进行安全性的操作
         */
        http
                .logout()
                //登录路径
                .logoutUrl("/logout")
                .invalidateHttpSession(true).permitAll();

        /**
         * 对http头部进行配置
         */
        http
                .headers();

        /**
         * 登录错误配置
         */
        http
                .exceptionHandling().accessDeniedPage("/fail");

        /**
         * 停用csrf过滤
         *
         */
        http
                .csrf().disable();

        /**
         * anonymous 配置一个匿名的认证
         * 当没有认证信息 默认装备一个authentication到SecurityContextHolder
         */

        /**
         * 添加自定义的动态权限访问拦截器
         */
        http.addFilterAt(dynamicSecurityInterceptor, FilterSecurityInterceptor.class);
    }

    /**
     * 用户认证数据支持
     *
     * @return
     */
    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        return new DbUserDetailServiceImpl();
    }

    /**
     * 配置认证管理器
     *
     * @param
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        /**
         * 可以配置passencoder 和 密码加盐
         */
        auth.userDetailsService(userDetailsService()).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {

    }
}
