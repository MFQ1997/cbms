package com.gdupt.cbms.core.intercepter;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/*
* @Name:ControllerInterceptor
* @Description:这个是每一个Controller执行之前都必须到达的链接器，在这里将数据源设置为主数据库
* @Date:2019
* */

@Component
public class ControllerInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*RequestCacheData.getInstance().setCache();
        RequestCacheDataItem.CURRENT_REFNO.set(UUID.randomUUID().toString());
        RequestCacheDataItem.CLIENT_IP.set(request.getRemoteAddr());
        RequestCacheDataItem.REQUEST_URL.set(request.getRequestURI());
        RequestCacheDataItem.REQUEST_TIME.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        //设置主库数据源，不建议，逻辑根据项目设置优化
        PropertiesObject po = SpringContextHolder.getBean("propertiesObject", PropertiesObject.class);
        DBConnStrUtil.setDataSourceByDbID(po.getDbID());*/
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //在每一次执行之后就必须将实例移除，不然就会将内存占满
        /*RequestCacheData.getInstance().removeCache();*/
        super.afterCompletion(request, response, handler, ex);
    }
}
