package com.kabasiji.springboot;

import com.kabasiji.springboot.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

     @Value("${test.name}")
     private String name;

     @Autowired
     private DemoService demoService;

     @Test
     public void contextLoads() {
          System.out.println(">>>>>>>>>>>>>>>>>> srpingboot test");
          System.out.println(">>>>>>>>>>>>>>>>>> srpingboot test yml ,name = " + name);

          demoService.print();
     }

}
