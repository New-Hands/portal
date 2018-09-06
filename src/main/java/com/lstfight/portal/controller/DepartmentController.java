package com.lstfight.portal.controller;

import com.lstfight.portal.dao.DepartmentDao;
import com.lstfight.portal.entity.SysDepartmentEntity;
import com.lstfight.portal.model.FluentHashMap;
import com.lstfight.portal.model.ResultBean;
import com.lstfight.portal.resource.ResourcePoint;
import com.lstfight.portal.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>部门管理接口</p>
 *
 * @author 李尚庭
 * @date 2018/8/15 0015 16:06
 */
@Controller
@RequestMapping("/department")
@ResourcePoint(name = "部门管理", value = "/department", code = "department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    DepartmentDao departmentDao;

    /**
     * 创建部门
     *
     * @param departmentEntity 部门实体
     * @return 创建结果
     */
    @PostMapping("/create")
    @ResourcePoint(name = "部门新增" ,value = "/department/create" ,code = "department_create")
    @ResponseBody
    public ResultBean createDepartment(@RequestBody SysDepartmentEntity departmentEntity) {
        return ResultBean.defaultSuccessResult();
    }

    /**
     * 获取所有部门列表
     *
     * @return 部门列表
     */
    @GetMapping("/getAll")
    @ResourcePoint(name = "部门列表" ,value = "/department/getAll" ,code = "department_get_all")
    @ResponseBody
    public ResultBean getAll() {
        List<SysDepartmentEntity> departmentEntityList = departmentDao.findAll();
        return ResultBean.defaultSuccessResult().addData(FluentHashMap.put("department",departmentEntityList));
    }


}
