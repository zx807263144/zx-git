package com.zx.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhongxin
 * @date 2017年9月8日
 * @description @FeignClient(value="eureka-service") 中value指定的是服务名
 */
@FeignClient(value="eureka-service")
public interface FeignHelloService {
    
    /**
     * @author zhongxin
     * @date 2017年9月8日
     * @description 对应的是服务名那边应用给出的映射
     * @param name
     * @return
     */
    @RequestMapping("/hi")
    String sayHello(@RequestParam("name") String name);
}
