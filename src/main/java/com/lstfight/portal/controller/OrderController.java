package com.lstfight.portal.controller;

import com.lstfight.portal.model.ResultBean;
import com.lstfight.portal.resource.ResourcePoint;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>员工工单处理</p>
 *
 * @author 李尚庭
 * @date 2018/8/27 0027 10:06
 */
@Controller
@RequestMapping("/order")
@ResourcePoint(name = "工单管理" ,value = "/order" ,code = "code")
public class OrderController {

    /**
     * <p>创建工单</p>
     *
     * @return 工单创建结果
     */
    @RequestMapping("/create")
    @ResourcePoint(name = "创建工单" ,value = "/order/create" ,code = "code_create")
    public ResultBean create() {
        return ResultBean.defaultSuccessResult();
    }
}
