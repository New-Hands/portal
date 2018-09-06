package com.lstfight.portal.controller;

import com.lstfight.portal.constant.DatabaseConstant;
import com.lstfight.portal.dao.SysResourceDao;
import com.lstfight.portal.entity.SysResourceEntity;
import com.lstfight.portal.model.FluentHashMap;
import com.lstfight.portal.model.ResultBean;
import com.lstfight.portal.resource.ResourcePoint;
import com.lstfight.portal.service.ResourceService;
import com.lstfight.systemutil.treeutil.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * <p>菜单操作接口，实际上是对资源进行的管理</p>
 *
 * @author 李尚庭
 * @date 2018/8/13 0013 13:55
 */
@Controller
@RequestMapping("/menu")
@ResourcePoint(name = "菜单管理", value = "/menu", code = "menu")
public class MenuController {

    @Autowired
    SysResourceDao resourceDao;

    @Autowired
    ResourceService resourceService;

    /**
     * 获取主菜单
     * 菜单是资源的表示
     *
     * @return 所有菜单列表
     */
    @RequestMapping("/getMenu")
    @ResourcePoint(name = "获取菜单", value = "/menu/getMenu", code = "get_menu")
    @ResponseBody
    public ResultBean getMenu() {
        //查询主菜单
        List<SysResourceEntity> resourceEntities = resourceDao.getAllByResourceType(DatabaseConstant.ResourceType.MENU.getType());
        Map<String, Object> map = FluentHashMap.put("menu", TreeUtil.treeTify(resourceEntities));
        return ResultBean.defaultSuccessResult().addData(map);
    }

    /**
     * <p>当前用户可用菜单列表</p>
     *
     * @return 当前用户可用列表
     */
    @RequestMapping("/getOwnMenu")
    @ResourcePoint(name = "获取当前用户菜单", value = "/menu/getOwnMenu", code = "get_own_menu")
    @ResponseBody
    public ResultBean getMenuOfUser() {
        //查询主菜单
        List<SysResourceEntity> resourceEntities = resourceService.getResourceTree();
        Map<String, Object> map = FluentHashMap.put("menu", TreeUtil.treeTify(resourceEntities));
        return ResultBean.defaultSuccessResult().addData(map);
    }
}
