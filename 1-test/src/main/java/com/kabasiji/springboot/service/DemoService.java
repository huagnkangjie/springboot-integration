package com.kabasiji.springboot.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * @author huang_kangjie
 * @create 2018-09-06 10:47
 **/
@Service
@Log4j2
public class DemoService {


     public void print(){
          System.out.println(">>>>>>>>>>>>>>>>>>>>> this is springboot test print()");
     }

     public void asyncTest1() {

          Thread current = Thread.currentThread();
          log.info("service 1:"+current.getId()+ ",name:"+current.getName());

          System.out.println(">>>>>>>>>>>>>>>>>>>>> 定时任务异步执行1");
     }

     public void asyncTest2() {
          Thread current = Thread.currentThread();
          log.info("service 2:"+current.getId()+ ",name:"+current.getName());
          System.out.println(">>>>>>>>>>>>>>>>>>>>> 定时任务异步执行2");
     }

     public void asyncTest3() {
          Thread current = Thread.currentThread();
          log.info("service 3:"+current.getId()+ ",name:"+current.getName());
          System.out.println(">>>>>>>>>>>>>>>>>>>>> 定时任务异步执行3");
     }
}
