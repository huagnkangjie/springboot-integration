package com.kabasiji.springboot.common.mulitdatasource.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 该注解注释在service方法上，标注为链接slaves库
 *
 * 主库master: 增、删、改
 * 从库slave:  查
 * @author huang_kangjie
 * @date 2018-12-14 22:15
 * @since 1.0.3
 **/
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ReadOnlyConnection {

}
