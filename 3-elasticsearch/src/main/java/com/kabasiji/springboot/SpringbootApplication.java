package com.kabasiji.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableElasticsearchRepositories(basePackages = "com.kabasiji.springboot.mapper.es")
public class SpringbootApplication {

     public static void main(String[] args) {
          SpringApplication.run(SpringbootApplication.class, args);
     }
}
