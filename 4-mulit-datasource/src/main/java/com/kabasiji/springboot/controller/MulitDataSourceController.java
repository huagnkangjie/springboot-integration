package com.kabasiji.springboot.controller;

import com.goodsogood.log4j2cm.annotation.HttpMonitorLogger;
import com.kabasiji.springboot.service.MulitDataSourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * elk
 * elasticsearch + logstash + kibana
 * @author huang_kangjie
 * @create 2018-09-06 10:34
 **/
@RestController
@RequestMapping("")
@AllArgsConstructor
@Api(value = "测试", tags = {"测试"})
@Log4j2
public class MulitDataSourceController {

     private final MulitDataSourceService mulitDataSourceService;

     @HttpMonitorLogger
     @GetMapping("/test1")
     @ApiOperation(value="测试数据源1",httpMethod="GET")
     public ResponseEntity<?> test1(){
          return new ResponseEntity<>(this.mulitDataSourceService.testData1(), HttpStatus.OK);
     }

     @HttpMonitorLogger
     @GetMapping("/test2")
     @ApiOperation(value="测试数据源2",httpMethod="GET")
     public ResponseEntity<?> test2(){
          return new ResponseEntity<>(this.mulitDataSourceService.testData2(), HttpStatus.OK);
     }


}
