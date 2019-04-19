package com.kabasiji.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication
//@EnableElasticsearchRepositories(basePackages = "com.kabasiji.springboot.mapper.es")
@EnableScheduling //发现定时任务
public class SpringbootApplication {

     /**
      * 自定义配置线程池
      * @return
      */
     @Bean
     public Executor getExecutor(){
          return getExecutor(2, 3, 5, "test1-");
     }

     private Executor getExecutor(int i, int i2, int i3, String s) {
          ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
          executor.setCorePoolSize(i);
          executor.setMaxPoolSize(i2);
          executor.setQueueCapacity(i3);
          executor.setThreadNamePrefix(s);
          executor.initialize();
          return executor;
     }

     public static void main(String[] args) {
          SpringApplication.run(SpringbootApplication.class, args);
     }
}
