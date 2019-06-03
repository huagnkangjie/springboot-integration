package com.kabasiji.springboot.common.mulitdatasource.core;

/**
 * 作用：
 * 1、保存一个线程安全的DatabaseType容器
 * @author huang_kangjie
 * @date 2018-12-14 22:15
 * @since 1.0.3
 **/
public class DatabaseContextHolder {
    private static final ThreadLocal<DatabaseType> contextHolder = new ThreadLocal<>();

    public static DatabaseType getDatabaseType(){
        return contextHolder.get();
    }

    public static void setDatabaseType(DatabaseType type) {
        contextHolder.set(type);
    }

    public static void clearDbType(){
        contextHolder.remove();
    }
}