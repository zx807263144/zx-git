package com.zx.config.redis;
//package com.zx.redisConfig;
//
//import java.lang.reflect.Method;
//
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.interceptor.KeyGenerator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
///**
// * @author zhongxin
// * @date 2017年8月18日
// * @description redis缓存设置
// */
////@Configuration
////@EnableCaching
//public class RedisCacheConfig extends CachingConfigurerSupport{
//    
//    /**
//     * 重写缓存的key生成策略
//     */
//    @Override
//    @Bean
//    public KeyGenerator keyGenerator() {
//        return new KeyGenerator() {
//            
//            @Override
//            public Object generate( Object target, Method method, Object... params ) {
//                StringBuilder sb = new StringBuilder();
//                sb.append( target.getClass().getName() );
//                sb.append( method.getName() );
//                
//                if (params != null ){
//                    for (Object param : params){
//                        sb.append( param.toString() );
//                    }
//                }
//                
//                return sb.toString();
//            }
//        };
//    }
//    
//    @SuppressWarnings( "rawtypes" )
//    @Bean
//    public CacheManager cacheManager(RedisTemplate redisTemplate){
//        RedisCacheManager redisCacheManager = new RedisCacheManager( redisTemplate );
//        //缓存过期时间，单位：秒
////        redisCacheManager.setDefaultExpiration( 60 );
//        return redisCacheManager;
//    }
//    
//    @Bean
//    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory){
//        RedisTemplate<String, String> redisTemplate = new StringRedisTemplate(redisConnectionFactory);
//        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>( Object.class );
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.setVisibility( PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY );
//        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper( objectMapper );
//        redisTemplate.setValueSerializer( jackson2JsonRedisSerializer );
//        redisTemplate.afterPropertiesSet();
//        return redisTemplate;
//    }
//}
