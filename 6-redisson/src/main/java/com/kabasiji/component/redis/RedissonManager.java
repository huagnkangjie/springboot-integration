package com.kabasiji.component.redis;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

/**
 * redisson配置
 */
@Configuration
public class RedissonManager {
    @Value("${spring.redis.clusters}")
    private  String cluster;

    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.timeout}")
    private Integer timeout;

    @Value("${spring.redis.lettuce.pool.max-idle}")
    private Integer maxPoolSize;



    //集群模式
    //@Bean
    //public RedissonClient getRedisson(){
    //    String[] nodes = cluster.split(",");
    //    //redisson版本是3.5，集群的ip前面要加上“redis://”，不然会报错，3.2版本可不加
    //	for(int i=0;i<nodes.length;i++){
    //	    nodes[i] = "redis://"+nodes[i];
    //	}
    //	RedissonClient redisson = null;
    //    Config config = new Config();
    //    config.useClusterServers() //这是用的集群server
    //    .setScanInterval(timeout) //设置集群状态扫描时间
    //    .addNodeAddress(nodes)
    //    .setPassword(password)
    //    ;
    //    redisson = Redisson.create(config);
    //
    //    //可通过打印redisson.getConfig().toJSON().toString()来检测是否配置成功
    //    return redisson;
    //}

     /**
      * 单机
      * @return
      */
     @Bean
     public RedissonClient getRedisson(){
          Config config = new Config();
          config.setLockWatchdogTimeout(30);
          String node = cluster;
          node = node.startsWith("redis://") ? node : "redis://" + node;
          SingleServerConfig serverConfig = config.useSingleServer()
                  .setAddress(node)
                  .setTimeout(timeout)
                  .setConnectionPoolSize(64)
                  .setConnectionMinimumIdleSize(maxPoolSize);
          serverConfig.setPassword(password);
          return Redisson.create(config);

     }

}
