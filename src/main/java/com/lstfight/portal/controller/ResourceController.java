package com.lstfight.portal.controller;

import com.lstfight.portal.entity.SysResourceEntity;
import com.lstfight.portal.model.ResultBean;
import com.lstfight.portal.resource.ResourcePoint;
import com.lstfight.portal.service.ResourceService;
import com.lstfight.systemutil.treeutil.CommonTree;
import com.lstfight.systemutil.treeutil.Tree;
import com.lstfight.systemutil.treeutil.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>系统资源操作接口</p>
 *
 * @author 李尚庭
 * @date 2018/8/13 0013 15:27
 */
@Controller
@RequestMapping("/resource")
@ResourcePoint(name = "资源管理", value = "/resource", code = "resource")
public class ResourceController {

    @Autowired
    ResourceService resourceService;

    /**
     * 根据资源id更改资源状态
     *
     * @param resourceId 资源id
     */
    @PostMapping("/updateResource")
    @ResourcePoint(name = "更新资源", value = "/resource/updateResource", code = "update_resource")
    public void updateResourceStatus(String resourceId) {

    }
    
    /**
     * 获取所有资源
     *
     * @return 所有资源 包括禁用的
     */
    @RequestMapping("/getAllResource")
    @ResourcePoint(name = "获取所有资源", code = "get_all_resource", value = "/resource/getAllResource")
    @ResponseBody
    public ResultBean getAllResource() {
        ResultBean resultBean = new ResultBean();
        List<SysResourceEntity> resourceEntities = resourceService.getAllResource();
        resultBean.setFlag(true);
        Map<String, Object> res = new HashMap<>(16);
        res.put("resource", resourceEntities);
        resultBean.setData(res);
        return resultBean;
    }

    /**
     * 获取树形格式的资源树
     *
     * @return 资源权限树
     */
    @RequestMapping("/getTreeResource")
    @ResourcePoint(name = "获取树形资源", code = "get_tree_resource", value = "/resource/getTreeResource")
    @ResponseBody
    public ResultBean getAllTreeFormatResource() {
        List<CommonTree<Tree>> resourceTree = TreeUtil.treeTify(resourceService.getAllResource());
        Map<String, Object> res = new HashMap<>(16);
        res.put("resource", resourceTree);
        return ResultBean.defaultSuccessResult().addData(res);
    }

    /**
     * 获取所有一级资源
     *
     * @return 一级资源列表
     */
    public ResultBean getAllSourceResource() {
        return ResultBean.defaultSuccessResult();
    }

    /**
     * 获取父资源的子资源
     *
     * @param parentId 父资源id
     * @return 子资源列表
     */
    public ResultBean getChildResourceByParent(String parentId) {
        return ResultBean.defaultSuccessResult();
    }


    /**
     * 将资源赋予到角色
     *
     * @param entity
     * @return
     */
    @PostMapping("/grantResource")
    @ResourcePoint(name = "授权", code = "grant_resource", value = "/resource/grantResource")
    @ResponseBody
    public ResultBean grantResourceToRole(SysResourceEntity entity) {
        return ResultBean.defaultSuccessResult();
    }
}
