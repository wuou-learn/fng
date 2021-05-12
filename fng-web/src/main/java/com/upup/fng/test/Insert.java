package com.upup.fng.test;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author wuou
 * @version 1.0.0
 * @date 2020/8/21 上午11:24
 */
@Target({TYPE, FIELD, METHOD})
@Retention(RUNTIME)
public @interface Insert {
}
