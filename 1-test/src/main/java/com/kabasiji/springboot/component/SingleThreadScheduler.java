package com.kabasiji.springboot.component;

import com.kabasiji.springboot.service.DemoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 *
 * 单线程执行任务
 * @author huang_kangjie
 * @date 2018-11-16 9:33
 **/
//@Component
@Log4j2
public class SingleThreadScheduler {

     private final DemoService demoService;

     @Autowired
     public SingleThreadScheduler(DemoService demoService) {
          this.demoService = demoService;
     }


     @Scheduled(cron="0/3 * * * * ?")
     public void executeFileDownLoadTask() {
          Thread current = Thread.currentThread();
          System.out.println("定时任务1:"+current.getId());
          log.info("ScheduledTest.executeFileDownLoadTask 定时任务1:"+current.getId()+ ",name:"+current.getName());

          demoService.asyncTest1();
     }

     @Scheduled(cron="0/3 * * * * ?")
     public void executeFileDownLoadTask2() {
          Thread current = Thread.currentThread();
          System.out.println("定时任务2:"+current.getId());
          log.info("ScheduledTest.executeFileDownLoadTask 定时任务2:"+current.getId()+ ",name:"+current.getName());
          demoService.asyncTest2();
     }

     @Scheduled(cron="0/1 * * * * ?")
     public void executeFileDownLoadTask3() {
          Thread current = Thread.currentThread();
          System.out.println("定时任务2:"+current.getId());
          log.info("ScheduledTest.executeFileDownLoadTask 定时任务3:"+current.getId()+ ",name:"+current.getName());
          demoService.asyncTest3();
     }


}
