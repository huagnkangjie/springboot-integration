package com.kabasiji.springboot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.goodsogood.log4j2cm.annotation.HttpMonitorLogger;
import com.kabasiji.springboot.mapper.DemoMapper;
import com.kabasiji.springboot.mode.db.DemoEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * elk
 * elasticsearch + logstash + kibana
 * @author huang_kangjie
 * @create 2018-09-06 10:34
 **/
@RestController
@RequestMapping("/test")
@AllArgsConstructor
@Api(value = "测试", tags = {"测试"})
@Log4j2
public class TestController {

     private final DemoMapper demoMapper;

     @HttpMonitorLogger
     @GetMapping("/index")
     @ApiOperation(value="测试",httpMethod="GET")
     public ResponseEntity<?> index(){
          Map<String, Object> dataMap = new HashMap<>();
          dataMap.put("key1", "kadsf");
          dataMap.put("key2", "1");
          dataMap.put("key3", "2");
          dataMap.put("key4", "3");

          Example example = new Example(DemoEntity.class);
          List<DemoEntity> list = this.demoMapper.selectByExample(example);

          log.debug("查询demo : {}", list);
          dataMap.put("list", list);

          return new ResponseEntity<>(dataMap, HttpStatus.OK);
     }

     @PostMapping("/getParam")
     @ApiOperation(value="测试",httpMethod="POST")
     public ResponseEntity<?> testParam(@RequestBody Map<String, Object> map, HttpServletRequest request) throws IOException {
          //StringBuffer buffer = new StringBuffer();
          //InputStream in = request.getInputStream();
          //BufferedInputStream bis = new BufferedInputStream(in);
          //byte[] bt = new byte[1024];
          //int iRead;
          //while ((iRead = bis.read(bt)) != -1) {
          //     buffer.append(new String(bt, 0, iRead, "UTF-8"));
          //}
          //String param = buffer.toString();
          //System.out.println(param);
          //return new ResponseEntity<>(param, HttpStatus.OK);
          log.debug("收到请求： map = {}", map);
          return new ResponseEntity<>("ok", HttpStatus.OK);
     }

     @GetMapping("/save")
     @ApiOperation(value="es",httpMethod="GET")
     public void  save() throws JsonProcessingException {


     }

     public static String getDate(){
          Date currentTime = new Date();
          SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          String dateString = formatter.format(currentTime);
          return dateString;
     }

}
