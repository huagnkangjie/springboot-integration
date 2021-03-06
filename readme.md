### 用于学习 springboot
##### 集成框架
* springboot 
* mybatis
* elasticsearch + logstash + kibaina
* swagger2
* MongoDB Redis

##### 分支说明
###### master
* 集成springboot、tk、swagger
* 简单的springboot应用

###### jsp
* 实现返回jsp模板

###### elasticsearch
* elasticsearch
* kibana
* 实现日志索引管理，日志追踪号

###### mulit-datasource
* 注解AOP实现数据源动态切换
* 基于tomcat自带的链接池的多数据源
 
##### Spring Boot 推荐的基础 POM 文件
* spring-boot-starter	核心 POM，包含自动配置支持、日志库和对 YAML 配置文件的支持。
* spring-boot-starter-amqp	通过 * spring-rabbit 支持 AMQP。
* spring-boot-starter-aop	包含 * spring-aop 和 AspectJ 来支持面向切面编程（AOP）。
* spring-boot-starter-batch	支持 Spring Batch，包含 HSQLDB。
* spring-boot-starter-data-jpa	包含 * spring-data-jpa、* spring-orm 和 Hibernate 来支持 JPA。
* spring-boot-starter-data-mongodb	包含 * spring-data-mongodb 来支持 MongoDB。
* spring-boot-starter-data-rest	通过 * spring-data-rest-webmvc 支持以 REST 方式暴露 Spring Data 仓库。
* spring-boot-starter-jdbc	支持使用 JDBC 访问数据库。
* spring-boot-starter-security	包含 * spring-security。
* spring-boot-starter-test	包含常用的测试所需的依赖，如 JUnit、Hamcrest、Mockito 和 * spring-test 等。
* spring-boot-starter-velocity	支持使用 Velocity 作为模板引擎。
* spring-boot-starter-web	支持 Web 应用开发，包含 Tomcat 和 * spring-mvc。
* spring-boot-starter-websocket	支持使用 Tomcat 开发 WebSocket 应用。
* spring-boot-starter-ws	支持 Spring Web Services。
* spring-boot-starter-actuator	添加适用于生产环境的功能，如性能指标和监测等功能。
* spring-boot-starter-remote-shell	添加远程 SSH 支持。
* spring-boot-starter-jetty	使用 Jetty 而不是默认的 Tomcat 作为应用服务器。
* spring-boot-starter-log4j	添加 Log4j 的支持。
* spring-boot-starter-logging	使用 Spring Boot 默认的日志框架 Logback。
* spring-boot-starter-tomcat	使用 Spring Boot 默认的 Tomcat 作为应用服务器。