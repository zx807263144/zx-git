package com.zx.background.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zx.background.service.CacheService;

/**
 * @author zhongxin
 * @date 2017年8月23日
 * @description 测试spring默认的ConcurrentMapCacheManager
 */
@RestController
@RequestMapping("/cacheController")
public class CacheController {
    
    @Autowired
    private CacheService cacheService;
    
    @RequestMapping(method=RequestMethod.GET)
    public String getByCache(){
        Long startTime = System.currentTimeMillis();
        long timestamp = cacheService.getByCache();
        Long endTime = System.currentTimeMillis();
        System.out.println( "耗时：" + ( endTime - startTime ) );
        return timestamp+"";
        
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public long save(){
        return cacheService.save();
    }
    
    @RequestMapping(method=RequestMethod.DELETE)
    public void delete(){
        cacheService.delele();
    }
}
