package com.lstfight.portal.controller;

import com.lstfight.portal.resource.ResourcePoint;
import com.lstfight.portal.dao.SysRoleDao;
import com.lstfight.portal.dao.SysUserDao;
import com.lstfight.portal.entity.SysRoleEntity;
import com.lstfight.portal.entity.SysUserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @date 2018/8/7 0007 16:05 
 * @author 李尚庭
 *
 */
@Controller
@RequestMapping("/")
@ResourcePoint(value = "/",name = "主界面",code = "home")
public class PortalController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PortalController.class);

    @Autowired
    SysUserDao sysUserDao;

    @Autowired
    SysRoleDao sysRoleDao;

    @RequestMapping("/login")
    @ResourcePoint(name = "登录界面", value = "/login", code = "login")
    public String login() {
        return "login";
    }

    @RequestMapping("/portal")
    @ResponseBody
    @ResourcePoint(value = "/portal",name = "主界面门户",code = "portal")
    public String root(HttpServletResponse response) {
        String rex = SecurityContextHolder.getContext().getAuthentication().getDetails().toString();
        return "portal" + rex;
    }

    /**
     * 获取系统相关信息
     *
     * @return 系统相关信息
     */
    @RequestMapping("/about")
    @ResponseBody
    @ResourcePoint(value = "/about",name = "关于",code = "about")
    public String aboutMe() {
        return "i am lst";
    }

    /**
     * 返回控制台界面
     *
     * @return 控制台
     */
    @RequestMapping("/index")
    @ResourcePoint(value = "/index",name = "欢迎界面",code = "welcome")
    public String welcome() {
        return "home";
    }

    @RequestMapping("/fail")
    @ResponseBody
    @ResourcePoint(value = "/fail",name = "错误界面",code = "fail")
    public String fail() {
        return "fail to login";
    }

    /**
     * 用户注册
     *
     * @return 返回注册结果
     */
    @RequestMapping("/register")
    @ResponseBody
    @ResourcePoint(value = "/register",name = "注册界面",code = "register")
    public String register() {
        //建立角色
        LOGGER.info("saveRole");
        SysRoleEntity roleEntity = new SysRoleEntity();
        roleEntity.setRoleName("staff");
        roleEntity.setRoleType((byte) 1);
        roleEntity.setRoleDefineType((byte) 1);
        roleEntity.setRoleBelongSystem("/portal");
        sysRoleDao.save(roleEntity);
        LOGGER.info("saveUser");
        SysUserEntity userEntity = new SysUserEntity();
        userEntity.setUserName("staff");
        userEntity.setUserPasswd("123456");
        userEntity.setUserStatus((byte) 1);
        userEntity.setUserType((byte)1);
        sysUserDao.save(userEntity);
        return "注册成功";
    }

}
