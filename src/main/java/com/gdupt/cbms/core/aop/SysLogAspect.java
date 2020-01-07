package com.gdupt.cbms.core.aop;

import com.alibaba.fastjson.JSON;
import com.gdupt.cbms.core.annotation.SysLog;
import com.gdupt.cbms.core.util.HttpContextUtil;
import com.gdupt.cbms.core.util.IpUtil;
import com.gdupt.cbms.entity.po.SystemLog;
import com.gdupt.cbms.service.SystemLogService;

import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Name:SysLogAspect
 * @Description:系统日志：切面处理类
 * @Date:2019
 */
@Aspect
@Component
public class SysLogAspect {

    @Autowired
    private SystemLogService systemLogService;

    //定义切点 @Pointcut
    //在注解的位置切入代码
    @Pointcut("@annotation(com.gdupt.cbms.core.annotation.SysLog)")
    public void logPoinCut() {
    }

    //切面 配置通知
    @AfterReturning("logPoinCut()")
    public void saveSysLog(JoinPoint joinPoint) {
        System.out.println("记录日志。。。");
        //保存日志
        SystemLog systemLog = new SystemLog();

        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();

        //获取操作
        SysLog sysLog = method.getAnnotation(SysLog.class);
        if (sysLog != null) {
            String value = sysLog.value();
            systemLog.setOperation(value);//保存获取的操作
        }

        //获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        //获取请求的方法名
        String methodName = method.getName();
        systemLog.setMethod(className + "." + methodName);


        systemLog.setCreateTime(new Date());
        //获取用户名
        String userName=(String) SecurityUtils.getSubject().getPrincipal();
        systemLog.setUserName(userName);
        //获取用户ip地址
        HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
        systemLog.setIp(IpUtil.getIpAddr(request));

        //调用service保存SysLog实体类到数据库
        systemLogService.save(systemLog);
    }

}
