package com.zx.background.service;

/**
 * @author zhongxin
 * @date 2017年8月23日
 * @description 测试spring默认的ConcurrentMapCacheManager
 */
public interface CacheService {
    long getByCache();
    
    long save();
    
    void delele();
}
