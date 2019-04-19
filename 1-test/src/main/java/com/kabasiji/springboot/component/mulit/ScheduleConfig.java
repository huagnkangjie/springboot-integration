package com.kabasiji.springboot.component.mulit;/*
package com.kabasiji.springboot.component.mulit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

*/
/**
 *
 * 加了此配置则能实现多线程执行任务
 *
 * @author huang_kangjie
 * @date 2018-11-16 10:53
 **//*

@Configuration
@EnableScheduling
public class ScheduleConfig implements SchedulingConfigurer {

     @Override
     public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
          taskRegistrar.setScheduler(taskExecutor());
     }

     @Bean
     public Executor taskExecutor() {
          return Executors.newScheduledThreadPool(100);
     }

}
*/
