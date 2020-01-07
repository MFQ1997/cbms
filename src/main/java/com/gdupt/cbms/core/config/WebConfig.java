package com.gdupt.cbms.core.config;

import com.gdupt.cbms.core.intercepter.ControllerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置自定义的拦截器
        registry.addInterceptor(new ControllerInterceptor());
        super.addInterceptors(registry);
    }
}