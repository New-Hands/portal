package com.lstfight.portal.controller;

import com.lstfight.portal.dao.SysRoleDao;
import com.lstfight.portal.entity.SysRoleEntity;
import com.lstfight.portal.model.ResultBean;
import com.lstfight.portal.resource.ResourcePoint;
import com.lstfight.portal.service.RoleService;
import com.lstfight.systemutil.log.OperatorLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 角色管理接口
 *
 * @author 李尚庭
 * @date 2018/8/13 0013 17:07
 */
@Controller
@RequestMapping("/role")
@ResourcePoint(name = "角色管理", value = "/role", code = "role")
public class RoleController {
    @Autowired
    RoleService roleService;


    @Autowired
    SysRoleDao roleDao;

    /**
     * 创建用户角色
     *
     * @param roleEntity 角色实体
     * @return 创建结果
     */
    @PostMapping("/createRole")
    @ResourcePoint(name = "新建角色", code = "create_role", value = "/role/createRole")
    @ResponseBody
    public ResultBean createRole(@RequestBody SysRoleEntity roleEntity) {
        roleService.save(roleEntity);
        return ResultBean.defaultSuccessResult();
    }

    /**
     * 获取所有角色
     *
     * @return 系统所有角色
     */
    @GetMapping("/getAll")
    @ResourcePoint(name = "获取所有角色", code = "get_all", value = "/role/getAll")
    @ResponseBody
    @OperatorLog
    public ResultBean getAllRole() {
        Map<String, Object> map = new HashMap<>(8);
        map.put("role", roleDao.findAll());
        return ResultBean.defaultSuccessResult().addData(map);
    }

    /**
     * 更新角色信息
     *
     * @param roleEntity 角色信息
     * @return 更新结果
     */
    @PostMapping("/updateRole")
    @ResourcePoint(name = "修改角色", value = "/role/updateRole", code = "update_role")
    @ResponseBody
    @OperatorLog
    public ResultBean updateRole(@RequestBody SysRoleEntity roleEntity) {
        return ResultBean.defaultSuccessResult();
    }

}
