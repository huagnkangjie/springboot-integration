package com.kabasiji.springboot.controller;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 整合jsp
 * @author huang_kangjie
 * @create 2018-10-10 9:35
 **/
@RestController
@AllArgsConstructor
@Api(value = "jsp", tags = {"jsp"})
@Log4j2
public class IndexController {

     /**
      * 返回index.jsp
      * @return
      */
     @RequestMapping("/index")
     public ModelAndView index() {
          ModelAndView modelAndView = new ModelAndView("index");
          modelAndView.addObject("name", " this is a jsp !");
          return modelAndView;
     }

}
