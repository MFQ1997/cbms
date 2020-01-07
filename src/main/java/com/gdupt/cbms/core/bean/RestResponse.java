package com.gdupt.cbms.core.bean;


import com.gdupt.cbms.core.util.JsonUtil;

/*
* @Description: 这是返回的数据库反馈
* */
public class RestResponse<T> {

    private String message = "";
    private String code = "00";
    private int count;
    private T data;

    /**
     * 返回一个新的实例
     */
    public static <T> RestResponse<T> newInstance() {
        return new RestResponse<T>();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return JsonUtil.objToJson(this);
    }
}
