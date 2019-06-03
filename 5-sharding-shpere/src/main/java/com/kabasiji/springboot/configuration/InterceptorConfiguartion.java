package com.kabasiji.springboot.configuration;

import com.kabasiji.springboot.common.filter.MyInterceptor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 注册拦截器
 * @author huang_kangjie
 * @create 2018-09-11 9:13
 **/
@Configuration
@Log4j2
public class InterceptorConfiguartion extends WebMvcConfigurerAdapter {

     @Override
     public void addInterceptors(InterceptorRegistry registry) {
          // 多个拦截器组成一个拦截器链
          // addPathPatterns 用于添加拦截规则
          // excludePathPatterns 用户排除拦截
          //添加权限验证拦截器
          registry.addInterceptor(new MyInterceptor());
          log.debug("======== 拦截器注册完毕 ========");
     }
}
