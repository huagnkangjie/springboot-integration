package com.kabasiji.springboot.mapper.impl;

import com.kabasiji.springboot.mapper.MongoDao;
import com.kabasiji.springboot.mode.vo.MongoDBForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author huang_kangjie
 * @create 2018-09-12 14:34
 **/
@Repository
public class MongoDaoImpl implements MongoDao {

     @Autowired
     private MongoTemplate mongoTemplate;

     @Override
     public void saveUser(MongoDBForm from) {
          this.mongoTemplate.save(from);
     }

     @Override
     public void saveUser(Object obj) {
          this.mongoTemplate.save(obj);
     }

     @Override
     public MongoDBForm findUserByUserName(String userName) {
          Query query=new Query(Criteria.where("userName").is(userName));
          return this.mongoTemplate.findOne(query , MongoDBForm.class);
     }

     @Override
     public void updateUser(MongoDBForm from) {
          Criteria criteria = Criteria.where("id").is(from.getId());
          Query query = new Query(criteria);
          Update update = Update.update("userName", from.getUserName()).set("passWord", from.getPassWord());
          mongoTemplate.updateMulti(query, update, MongoDBForm.class);
     }

     @Override
     public void deleteUserById(Long id) {
          Criteria criteria = Criteria.where("id").is(id);
          Query query = new Query(criteria);
          this.mongoTemplate.remove(query,MongoDBForm.class);
     }

     @Override
     public List<MongoDBForm> findByPage(MongoDBForm from, Pageable pageable) {
          Query query = new Query();
          if (from != null && from.getUserName() != null) {
               //模糊查询
               query = new Query(Criteria.where("userName").regex("^" + from.getUserName()));
          }
          List<MongoDBForm> list = this.mongoTemplate.find(query.with(pageable), MongoDBForm.class);
          return list;
     }

     @Override
     public void insertAll(List<MongoDBForm> forms) {
          this.mongoTemplate.insertAll(forms);
     }

     @Override
     public List<MongoDBForm> findAll() {
          return this.mongoTemplate.findAll(MongoDBForm.class);
     }

}
