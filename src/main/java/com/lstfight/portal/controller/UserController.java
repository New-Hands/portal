package com.lstfight.portal.controller;

import com.lstfight.portal.entity.SysUserEntity;
import com.lstfight.portal.model.ResultBean;
import com.lstfight.portal.resource.ResourcePoint;
import com.lstfight.portal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>用户操作接口</p>
 *
 * @author 李尚庭
 * @date 2018/8/13 0013 16:30
 */
@Controller
@RequestMapping("/user")
@ResourcePoint(name = "用户管理", value = "/user", code = "user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 创建用户
     *
     * @param userEntity 用户实体
     */
    @PostMapping("/createUser")
    @ResourcePoint(name = "新建用户", value = "/user/createUser", code = "create_user")
    public void createUser(SysUserEntity userEntity) {
        userService.createUser(userEntity);
    }

    /**
     * 根据当前登录用户获取所辖用户列表
     *
     * @param adminId 当前登录管理用户
     * @return
     */
    @GetMapping("/getUser")
    @ResourcePoint(name = "查询用户", value = "/user/getUser", code = "get_user")
    @ResponseBody
    public ResultBean getUserListByAdminId(String adminId) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(userName);
        List<SysUserEntity> users = userService.getUserListByUserId(userService.getUserIdByUserName(userName));
        Map<String, Object> res = new HashMap<>(16);
        res.put("user", users);
        return ResultBean.defaultSuccessResult().addData(res);
    }
}
