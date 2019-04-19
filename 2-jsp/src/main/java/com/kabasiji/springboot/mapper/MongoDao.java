package com.kabasiji.springboot.mapper;

import com.kabasiji.springboot.mode.vo.MongoDBForm;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * mongo操作接口
 * @author huang_kangjie
 * @create 2018-09-12 14:32
 **/
public interface MongoDao {

     /**
      * 新增纪录
      * @param from
      */
     void saveUser(MongoDBForm from);

     /**
      * 新增任意纪录
      * @param obj
      */
     void saveUser(Object obj);

     /**
      * 条件查询
      * @param userName
      * @return
      */
     MongoDBForm findUserByUserName(String userName);

     /**
      * 更新指定的属性
      * @param from
      */
     void updateUser(MongoDBForm from);

     /**
      * 根据id删除
      * @param id
      */
     void deleteUserById(Long id);

     /**
      * 分页查询
      * @param from
      * @param pageable
      * @return
      */
     List<MongoDBForm> findByPage(MongoDBForm from, Pageable pageable);

     /**
      * 插入集合
      * @param forms
      */
     void insertAll(List<MongoDBForm> forms);

     /**
      * 查询集合
      * @return
      */
     List<MongoDBForm> findAll();
}
