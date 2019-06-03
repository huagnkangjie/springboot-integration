package com.kabasiji.springboot.common.mulitdatasource.core;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源（需要继承AbstractRoutingDataSource）
 * 重写jdbc获取数据源
 * 线程安全
 * @author huang_kangjie
 * @date 2018-12-14 22:15
 * @since 1.0.3
 **/
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DatabaseContextHolder.getDatabaseType();
    }
}