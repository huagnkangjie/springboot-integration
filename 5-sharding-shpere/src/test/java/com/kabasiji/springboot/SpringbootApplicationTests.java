package com.kabasiji.springboot;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kabasiji.springboot.mapper.UserMapper;
import com.kabasiji.springboot.mode.db.UserEntity;
import com.kabasiji.springboot.service.DemoService;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
public class SpringbootApplicationTests {

     @Value("${test.name}")
     private String name;

     @Autowired
     private DemoService demoService;

     @Autowired
     private UserMapper userMapper;

     @Test
     public void contextLoads() {
          System.out.println(">>>>>>>>>>>>>>>>>> srpingboot test");
          System.out.println(">>>>>>>>>>>>>>>>>> srpingboot test yml ,name = " + name);

          demoService.print();
     }

     @Test
     public void testShardUserInsert() {
          UserEntity userEntity = new UserEntity();
          userEntity.setName("用户-" + (int) (Math.random() * 100));
          userEntity.setPassword("123456");
          userEntity.setPhone("1861234562");
          userEntity.setAge(18);
          userEntity.setGender(1);
          userEntity.setCreateTime(new Date());
          userMapper.insert(userEntity);

          log.debug("user_id->{}", userEntity.getUserId());
     }

     @Test
     public void testShardUserGet() {
          log.debug("user->{}", userMapper.selectByPrimaryKey(246638689332101120L));
     }

     @Test
     public void testShardUserFind() {
          Example example = new Example(UserEntity.class);
          example.createCriteria().andLike("name", "用户-%");
          example.orderBy("userId").desc();
          log.debug("users->{}", userMapper.selectByExample(example));
     }

     @Test
     public void testShardUserUpdate() {
          UserEntity userEntity = new UserEntity();
          userEntity.setUserId(246638689332101120L);
          userEntity.setPassword("654321");
          userEntity.setUpdateTime(new Date());
          log.debug("success->{}", userMapper.updateByPrimaryKeySelective(userEntity) > 0);
     }

     @Test
     public void testShardUserJoin() {
          log.debug("userOthers->{}", userMapper.findAliasByName("测试X"));
          log.debug("userOthers->{}", userMapper.findAliasByName("用户1"));
     }

     @Test
     public void testShardUserCount() {
          log.debug("users.count->{}", userMapper.count());
     }

     @Test
     public void testShardPageHelper() {
          Page<UserEntity> page = PageHelper.startPage(1, 10).doSelectPage(userMapper::selectAll);
          log.debug("users.page1->{}", page);
          log.debug("users.page1.size->{}", page.size());
     }

}
