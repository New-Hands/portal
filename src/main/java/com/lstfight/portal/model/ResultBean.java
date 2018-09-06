package com.lstfight.portal.model;

import java.util.Map;

/**
 * 统一返回结果
 * 实现fluent 编程接口
 * @author 李尚庭
 * @date 2018/8/13 0013 15:18
 */
public class ResultBean {
    private boolean flag;
    private String message;
    private Map<String, Object> data;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    /**
     * 默认成功请求
     *
     * @return 一个默认成功的结果
     */
    public static ResultBean defaultSuccessResult() {
        return fluent().addFlag(true).addMessage("请求成功！");
    }

    public static ResultBean fluent() {
        return new ResultBean();
    }

    public ResultBean addMessage(String message) {
        this.setMessage(message);
        return this;
    }

    public ResultBean addFlag(boolean flag) {
        this.setFlag(flag);
        return this;
    }

    public ResultBean addData(Map<String, Object> data) {
        this.setData(data);
        return this;
    }

}
