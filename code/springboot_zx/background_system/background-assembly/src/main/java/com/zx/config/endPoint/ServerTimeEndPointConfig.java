package com.zx.config.endPoint;

import java.util.Map;

import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zx.endPoint.ServerTimeEndPoint;

/**
 * @author zhongxin
 * @date 2017年8月31日
 * @description 创建端点配置类，并注册我们的端点 ServerTimeEndpoint
 */
@Configuration
public class ServerTimeEndPointConfig {
    
    @Bean
    public static Endpoint<Map<String,Object>> serverTime(){
        return new ServerTimeEndPoint();
    } 
}
