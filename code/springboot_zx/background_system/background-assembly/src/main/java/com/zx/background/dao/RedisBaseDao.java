package com.zx.background.dao;

/**
 * @author zhongxin
 * @date 2017年8月18日
 * @description redis基本操作dao
 */
public interface RedisBaseDao {
    
    void addValue(String key, String value);
    
    String getValue(String key);
}