package com.upup.fng.engine.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author wuou
 * @version 1.0.0
 * @date 2021/2/20 下午4:26
 */
@Aspect
@Component
public class LogAspect {
    
    @Autowired
    private FngLog fngLog;

    @Pointcut("execution(* com.upup.fng.service..*.*(..))")
    public void logService(){
        //TODO
    }

    @Pointcut("execution(* com.upup.fng.web..*.*(..))")
    public void logController(){
        //TODO
    }

    @Around("logService() || logController()")
    public Object around(ProceedingJoinPoint point) throws Throwable{
        //结果对象
        Object res = null;

        //目标方法
        MethodSignature ms = (MethodSignature)point.getSignature();

        //目标方法日志标记注解
        LogTag lt = null;
        //是否需要记录日志
        boolean flage = ms.getMethod().isAnnotationPresent(LogTag.class);
        String cname = null;
        String mname = null;
        if(flage){
            lt = ms.getMethod().getAnnotation(LogTag.class);
            cname = point.getTarget().getClass().getName();
            mname = ms.getMethod().getName();
            //开始日志
            if(lt.POINTS() != null){
                fngLog.error("user [wuou] test");
            }
        }
        
        res = point.proceed();
        
        return res;
    }
}
