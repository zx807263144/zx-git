package com.zx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zx.service.HelloService;

/**
 * @author zhongxin
 * @date 2017年9月6日
 * @description 测试ribbon负载均衡情况
 */
@RestController
@RequestMapping("/helloController")
public class HelloController {
    
    @Autowired
    private HelloService helloService;
    
    /**
     * @author zhongxin
     * @date 2017年9月6日
     * @description 测试连接
     * @param name
     * @return
     */
    @RequestMapping(method=RequestMethod.GET)
    public String hi(String name){
        return helloService.eurekaService( name );
    }
}
