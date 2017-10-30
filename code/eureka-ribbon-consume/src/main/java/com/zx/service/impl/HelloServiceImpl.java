package com.zx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zx.service.HelloService;
/**
 * @author zhongxin
 * @date 2017年9月6日
 * @description 测试ribbon负载均衡情况
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private RestTemplate restTemplate;
    
    /**
     * 用应用名代替ip，在ribbon中它会根据服务名来选择具体的服务实例，根据服务实例在请求的时候会用具体的url替换掉服务名
     * @HystrixCommand注解。该注解对该方法创建了熔断器的功能，并指定了fallbackMethod熔断方法，即如果远程服务连接失败调用的方法
     */
    @Override
    @HystrixCommand(fallbackMethod="eurekaServiceError")
    public String eurekaService( String name ) {
        return restTemplate.getForObject( "http://EUREKA-SERVICE/hi?name="+name, String.class );
    }

    public String eurekaServiceError(String name){
        return name + "!Sorry, the connection of sureka-service is timeout!";
    }
}
