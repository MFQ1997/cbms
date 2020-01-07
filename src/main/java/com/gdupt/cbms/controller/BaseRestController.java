package com.gdupt.cbms.controller;


/*
* @Name:BaseRestController
* @Description:这个是基础的Controller
* @Date:2019
* */

import com.gdupt.cbms.core.bean.RestResponse;

public class BaseRestController {


    /**
     * @Name:success()
     * @Description:这个是返回成功的信息
     * @param :T(泛型)
     */
    protected <T> RestResponse<T> success(T result) {
        //实例化封装好的信息类
        RestResponse<T> restResponse = RestResponse.newInstance();
        restResponse.setData(result);
        return restResponse;
    }


    /**
     * @Name:success()
     * @Description:这个是返回成功的信息
     * @param :T(泛型)
     */
    protected <T> RestResponse<T> success(String message ,String code,int count,T data) {
        //实例化封装好的信息类
        RestResponse<T> restResponse = RestResponse.newInstance();
        //设置提示信息
        restResponse.setMessage(message);
        //设置状态码
        restResponse.setCode(code);
        //设置返回结果
        restResponse.setCount(count);
        //设置返回结果
        restResponse.setData(data);
        return restResponse;
    }



    /*
    * @Name:fail()
    * @Description:这个是返回失败的信息
    * @Param:T(泛型)
    * */
    protected <T> RestResponse<T> fail(String message,String code,int count,T result){
        //实例化封装好的信息类
        RestResponse<T> restResponse = RestResponse.newInstance();
        //设置提示信息
        restResponse.setMessage(message);
        //设置返回结果
        restResponse.setCount(count);
        //设置状态码
        restResponse.setCode(code);
        //设置返回结果
        restResponse.setData(result);
        return restResponse;
    }

}
