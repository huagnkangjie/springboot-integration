package com.kabasiji.springboot.common.mulitdatasource.core;

import com.kabasiji.springboot.common.mulitdatasource.annotation.ReadOnlyConnection;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * aop
 * 拦截 @ReadOnlyConnection注解
 * 默认为master，如有有该注解，则只能读数据，查询从库
 * @author huang_kangjie
 * @date 2018-12-14 22:15
 * @since 1.0.3
 **/
@Aspect
@Component
public class ReadOnlyConnectionInterceptor implements Ordered {

    public static final Logger logger = LoggerFactory.getLogger(ReadOnlyConnectionInterceptor.class);

    @Around("@annotation(readOnlyConnection)")
    public Object proceed(ProceedingJoinPoint proceedingJoinPoint,ReadOnlyConnection readOnlyConnection) throws Throwable {
        try {
            logger.info("set database connection to read only");
            DatabaseContextHolder.setDatabaseType(DatabaseType.test1);
            Object result = proceedingJoinPoint.proceed();
            return result;
        }finally {
            DatabaseContextHolder.clearDbType();
            logger.info("restore database connection");
        }
    }


    @Override
    public int getOrder() {
        return 0;
    }
}
