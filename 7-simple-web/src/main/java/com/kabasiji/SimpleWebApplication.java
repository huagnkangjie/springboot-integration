package com.kabasiji;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class SimpleWebApplication {

     private static Logger logger = LoggerFactory.getLogger(SimpleWebApplication.class);



     public static void main(String[] args) {
          logger.info("启动程序！！");
          Runtime.getRuntime().addShutdownHook(new Thread(){
               @Override
               public void run() {
                    try {
                         logger.info("这个钩子启动");
                         TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                         e.printStackTrace();
                    }
                    logger.info("这个钩子退出");
               }
          });
          SpringApplication.run(SimpleWebApplication.class, args);
     }

}
