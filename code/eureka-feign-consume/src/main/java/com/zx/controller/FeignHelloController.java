package com.zx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zx.service.FeignHelloService;

/**
 * @author zhongxin
 * @date 2017年9月8日
 * @description
 */
@RestController
@RequestMapping("/feignHelloController")
public class FeignHelloController {
    
    @Autowired
    private FeignHelloService feignHelloService;
    
    @RequestMapping(method=RequestMethod.GET)
    public String sayHello(String name){
        return feignHelloService.sayHello( name );
    }
}
