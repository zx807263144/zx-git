//package com.zx.datasource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//
//import redis.clients.jedis.JedisPoolConfig;
//
///**
// * @author zhongxin
// * @date 2017年8月18日
// * @description JavaConfig的形式创建redis
// */
////@Configuration
////@PropertySource("classpath:config/redis.peoperties")
//public class RedisDataSourceConfig {
//    
//    @Autowired
//    private Environment environment;
//    
//    @Bean
//    public RedisConnectionFactory redisConnectionFactory(){
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        
//        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
//        jedisConnectionFactory.setHostName( environment.getProperty( "redis.host" ).trim() );
//        jedisConnectionFactory.setPort( Integer.parseInt( environment.getProperty( "redis.6379" ).trim()) );
//        jedisConnectionFactory.setPassword( environment.getProperty( "redis.password" ).trim() );
//        jedisConnectionFactory.setDatabase( Integer.parseInt( environment.getProperty( "redis.database" ).trim() ));
//        jedisConnectionFactory.setUsePool( true );
//        jedisConnectionFactory.setPoolConfig( jedisPoolConfig );
//        
//        return jedisConnectionFactory;
//    }
//}
