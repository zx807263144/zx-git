package com.zx.background.service.impl;

import java.util.Date;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.zx.background.service.CacheService;

@Service
public class CacheServiceImpl implements CacheService {

    @Override
    @Cacheable(value="concurrentHashMapCache")
    public long getByCache() {
        try {
            Thread.sleep( 3*1000 );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        System.out.println( "不是从缓存中读取数据" );
        return new Date().getTime();
    }

    @Override
    @CachePut(value="concurrentHashMapCache")
    public long save() {
        long timestamp = new Date().getTime();
        System.out.println( "进行缓存：" + timestamp );
        return timestamp;
    }

    @Override
    @CacheEvict(value="concurrentHashMapCache")
    public void delele() {
        System.out.println( "删除缓存" );
    }

}
