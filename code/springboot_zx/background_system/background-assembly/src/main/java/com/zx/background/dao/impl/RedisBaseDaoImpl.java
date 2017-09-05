//package com.zx.background.dao.impl;
//
//import javax.annotation.PostConstruct;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.stereotype.Repository;
//
//import com.zx.background.dao.RedisBaseDao;
//
///**
// * @author zhongxin
// * @date 2017年8月18日
// * @description redis 基本dao操作
// */
//@Repository
//public class RedisBaseDaoImpl implements RedisBaseDao {
//
//    @Autowired
//    private RedisTemplate<String, String> redisTemplate;
//    
//    private ValueOperations<String, String> valueOperations;
//    
//    @PostConstruct
//    public void initValueOperations(){
//        this.valueOperations = redisTemplate.opsForValue();
//    }
//    
//    @Override
//    public void addValue( String key, String value ) {
//        valueOperations.set( key, value );
//    }
//
//    @Override
//    public String getValue( String key ) {
//        return valueOperations.get( key );
//    }
//
//}
