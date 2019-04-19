package com.kabasiji.springboot.controller;

import com.goodsogood.log4j2cm.annotation.HttpMonitorLogger;
import com.kabasiji.springboot.mapper.MongoDao;
import com.kabasiji.springboot.mode.vo.MongoDBDetailForm;
import com.kabasiji.springboot.mode.vo.MongoDBForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

/**
 * mongo测试
 * @author huang_kangjie
 * @create 2018-09-12 15:12
 **/
@RestController
@RequestMapping("/mongo")
@AllArgsConstructor
@Api(value = "MongoDB测试", tags = {"MongoDB测试"})
@Log4j2
public class MongoController {

     private final MongoDao mongoDao;

     @HttpMonitorLogger
     @GetMapping("/save")
     @ApiOperation(value="保存",httpMethod="GET")
     public ResponseEntity<?> save(String name){
          int random = new Random().nextInt(9999999);
          MongoDBForm from = new MongoDBForm();
          from.setId(Long.valueOf(random));
          from.setUserName(name);
          from.setEmail(random + "@qq.com");
          from.setNickName(name + random);
          from.setPassWord(random+"");
          from.setRemark("标签" + random);
          this.mongoDao.saveUser(from);

          MongoDBDetailForm detailForm = new MongoDBDetailForm();
          detailForm.setDetailId(random + "");
          detailForm.setDescription("详细信息" + random);
          this.mongoDao.saveUser(detailForm);


          return new ResponseEntity<>("ok", HttpStatus.OK);
     }

     @HttpMonitorLogger
     @GetMapping("/get")
     @ApiOperation(value="查询",httpMethod="GET")
     public ResponseEntity<?> get(String name){
          MongoDBForm form =this.mongoDao.findUserByUserName(name);
          return new ResponseEntity<>(form, HttpStatus.OK);
     }

     @HttpMonitorLogger
     @GetMapping("/list")
     @ApiOperation(value="查询列表",httpMethod="GET")
     public ResponseEntity<?> getList(String name){
          List<MongoDBForm> form =this.mongoDao.findAll();
          return new ResponseEntity<>(form, HttpStatus.OK);
     }

     @HttpMonitorLogger
     @GetMapping("/page")
     @ApiOperation(value="查询分页",httpMethod="GET")
     public ResponseEntity<?> page(String name){
          Pageable pageable=new PageRequest(1, 2);
          MongoDBForm from = new MongoDBForm();
          from.setUserName(name);
          List<MongoDBForm> form =this.mongoDao.findByPage(from, pageable);
          return new ResponseEntity<>(form, HttpStatus.OK);
     }

}
