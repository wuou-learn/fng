package com.upup.fng.engine.log;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 日志注解
 * @author wuou
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogTag {
    
    Log LOG() default Log.OPERATE;
    
    LogLevel LEVEL() default LogLevel.INFO;
    
    LogPoint[] POINTS() default {LogPoint.BEFORE, LogPoint.AFTER, LogPoint.THROW};
}
