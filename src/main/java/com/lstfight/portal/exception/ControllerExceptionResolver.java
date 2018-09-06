package com.lstfight.portal.exception;

import com.lstfight.portal.model.ResultBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 处理Controller抛出的异常
 * Servlet的核心是基于Request Response
 *
 * @author 李尚庭
 * @date 2018/8/13 0013 17:12
 */
@RestControllerAdvice
public class ControllerExceptionResolver  {

    /**
     * 统一日志处理并记录日志
     *
     * @param request   请求
     * @param response  响应
     * @param exception 捕获异常
     * @return 统一处理结果
     */
    @ExceptionHandler(value = Exception.class)
    public ResultBean handleException(HttpServletRequest request, HttpServletResponse response, Exception exception) {
        ResultBean resultBean = new ResultBean();
        resultBean.setFlag(false);
        resultBean.setMessage(exception.getStackTrace()[0].toString());
        return resultBean;
    }
}
