package com.zx.connect;

import javax.annotation.PostConstruct;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.stereotype.Component;

/**
 * @author zhongxin
 * @date 2017年9月20日
 * @description 获取RedisssonClient连接类
 */
@Component
public class RedissonConnector {
    private RedissonClient redissonClient;
    
    @PostConstruct
    public void init(){
        Config config = new Config();
        SingleServerConfig singleServerConfig =  config.useSingleServer();
        singleServerConfig.setAddress("http://192.168.210.131:6379")
                            .setPassword( "zx_redis" );
        redissonClient = Redisson.create(config);
    }
    
    public RedissonClient getClient(){
        return redissonClient;
    }
}
