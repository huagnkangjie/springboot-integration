package com.kabasiji.springboot;

import com.kabasiji.springboot.common.pojo.RedisCache;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author huang_kangjie
 * @date 2019-01-17 10:32
 * @since 1.0.3
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
public class RedisTest {

     @Autowired
     private StringRedisTemplate redisTemplate;

     @Test
     @SuppressWarnings("unchecked")
     public void zsetTest(){

          //1、存放后会自动排序，分数一样的，先入则排前面

          //redisTemplate.opsForZSet().add("test","zhang3", 80);
          //redisTemplate.opsForZSet().add("test","li4", 80);
          //redisTemplate.opsForZSet().add("test","wang5", 80);
          //redisTemplate.opsForZSet().add("test","zhao6", 80);
          //redisTemplate.opsForZSet().add("test","sun7", 80);
          //redisTemplate.opsForZSet().add("test","zhou8", 80);
          //redisTemplate.opsForZSet().add("test","wu9", 80);
          //redisTemplate.opsForZSet().add("test","zheng10", 80);
          redisTemplate.opsForZSet().add("test","zhang3", 80);
          redisTemplate.opsForZSet().add("test","li4", 85);
          redisTemplate.opsForZSet().add("test","wang5", 85);
          redisTemplate.opsForZSet().add("test","zhao6", 60);
          redisTemplate.opsForZSet().add("test","sun7", 90);
          redisTemplate.opsForZSet().add("test","zhou8", 50);
          redisTemplate.opsForZSet().add("test","wu9", 55);
          redisTemplate.opsForZSet().add("test","zheng10", 100);

          //取范围，取的是排序后的索引，且索引是从0开始
          Set rows = redisTemplate.opsForZSet().range("test",1,5);
          print("range", rows);

          //满足这个分数的个数
          long count = redisTemplate.opsForZSet().count("test", 90, 100);
          log.debug(">>>>>>>>>>>>>>>>>>> count = {}", count);

          //按照值来排序的取值,这个排序只有在有相同分数的情况下才能使用，如果有不同的分数则返回值不确定
          rows = redisTemplate.opsForZSet().rangeByLex("test", RedisZSetCommands.Range.range().gte("sun7"));
          print("rangeByLex", rows);

          //获取所有的zset key
          //ScanOptions.NONE  获取所有的zset key
          //ScanOptions.scanOptions().match("C").build()  匹配获取键位map1的键值对,不能模糊匹配。
          //Cursor<ZSetOperations.TypedTuple<String>> cursor = redisTemplate.opsForZSet().scan("test", ScanOptions.NONE);
          Cursor<ZSetOperations.TypedTuple<String>> cursor = redisTemplate.opsForZSet().scan("test", ScanOptions.scanOptions().match("zhou8").build());
          while (cursor.hasNext()){
               ZSetOperations.TypedTuple typedTuple = cursor.next();
               System.out.println("扫描绑定数据:" + typedTuple.getValue() + "--->" + typedTuple.getScore());
          }

          //获取从设置下标开始的设置长度的元素值
          RedisZSetCommands.Range range = new RedisZSetCommands.Range();
          RedisZSetCommands.Limit limit = new RedisZSetCommands.Limit();
          limit.count(2);
          //起始下标为0
          limit.offset(1);
          redisTemplate.opsForZSet().rangeByLex("test",range,limit).forEach(v -> System.out.println("按照值来排序的限定取值:" +
                  v));


          //按照分数排序
          //offset 从0开始
          redisTemplate.opsForZSet().rangeByScore("test",90,100, 0, 1).forEach(v -> System.out
                  .println
                  ("按照分数排序:" +
                  v));

          pringLog();

          //按照位置排序取值和分数
          //start 从0开始
          Set<ZSetOperations.TypedTuple<String>> tupleSet = redisTemplate.opsForZSet().rangeWithScores("test",3,5);
          tupleSet.forEach(v -> System.out.printf("按照位置排序取值和分数:%s-->%s\n",v.getValue(),v.getScore()));

          pringLog();

          //按照分数位置排序取值和分数
          Set<ZSetOperations.TypedTuple<String>> scoreSet = redisTemplate.opsForZSet().rangeByScoreWithScores("test",
                  90,100);
          scoreSet.forEach(v -> System.out.printf("按照分数位置排序取值和分数:%s-->%s\n",v.getValue(),v.getScore()));

          pringLog();

          //按照值来倒序取值
          redisTemplate.opsForZSet().reverseRange("test",0,3).forEach(v -> System.out.println("按照值来倒序取值:" + v));

          pringLog();

          //按照分数来倒序取值
          redisTemplate.opsForZSet().reverseRangeByScore("test",2,5).forEach(v -> System.out.println("按照分数来倒序取值:" + v));

          System.out.println("取field的值： " + redisTemplate.opsForZSet().score("test","zheng10"));

          //获取变量中元素的个数
          System.out.println("获取变量中元素的个数:" + redisTemplate.opsForZSet().zCard("test"));

          pringLog();

          batchZset(getData());


     }

     private void print(String msg, Set rows) {
          Iterator it = rows.iterator();
          while (it.hasNext()) {
               log.debug(">>>>>>>>>>>>>>>>>>>> msg={} ; {}", msg, it.next());
          }

     }

     private void pringLog() {
          System.out.println();
          System.out.println("-------------------------------------");
          System.out.println();

     }

     private List<RedisCache> getData(){
          long st = System.currentTimeMillis();
          List<RedisCache> data = new ArrayList<>();
          for(int i = 0; i < 200000; i++) {
               RedisCache cache = new RedisCache();
               cache.setKey("test");
               cache.setField("test" + i);
               cache.setValue(i+"");
               data.add(cache);
          }
          long et = System.currentTimeMillis();
          System.out.println("生成data耗时：" + (et - st));
          return data;
     }

     public void batchZset(List<RedisCache> data){
          long st = System.currentTimeMillis();
          try{
               final RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
               redisTemplate.executePipelined((RedisCallback<String>) conn -> {
                    for(RedisCache hashCache : data) {
                         byte[] key = serializer.serialize(hashCache.getKey());
                         byte[] field = serializer.serialize(hashCache.getField());

                         conn.zAdd(key,Double.valueOf(hashCache.getValue()), field);

                         //conn.hSet(key, field, value);
                    }
                    return null;
               }, serializer);
          } catch(Exception e){
               log.error("批量hash写出错：" + e.getMessage(), e);
          }
          long et = System.currentTimeMillis();
          System.out.println("批量写zset耗时：" + (et - st));
     }



}
