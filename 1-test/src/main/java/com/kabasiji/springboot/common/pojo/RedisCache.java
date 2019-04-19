package com.kabasiji.springboot.common.pojo;

import lombok.Data;

/**
 * hash 数据结构
 * @author huang_kangjie
 * @date 2019-01-11 14:55
 * @since 1.0.3
 **/
@Data
public class RedisCache {

     private String key;

     /**
      * hash值的key
      */
     private String hkey;

     /**
      * hash的字段
      */
     private String field;

     /**
      * 值
      */
     private String value;

}
