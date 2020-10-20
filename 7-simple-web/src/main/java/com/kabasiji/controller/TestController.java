package com.kabasiji.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huang_kangjie
 * @date 2020/10/20 0020 17:31
 */
@RestController("/test")
public class TestController {

     @GetMapping("/index")
     public String test(){

          return "{\"msg\":\"ok " + System.currentTimeMillis() + "\"}";
     }

}

