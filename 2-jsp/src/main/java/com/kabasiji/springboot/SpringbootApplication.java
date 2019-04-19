package com.kabasiji.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
//@EnableElasticsearchRepositories(basePackages = "com.kabasiji.springboot.mapper.es")
/**
 * 使用外部的tomcat需要继承SpringBootServletInitializer
 */
public class SpringbootApplication extends SpringBootServletInitializer {

     public static void main(String[] args) {
          SpringApplication.run(SpringbootApplication.class, args);
     }
}
