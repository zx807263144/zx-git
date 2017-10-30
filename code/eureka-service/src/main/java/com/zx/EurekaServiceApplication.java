package com.zx;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhongxin
 * @date 2017年9月5日
 * @description @EnableEurekaClient客户端，这个应用是服务提供者
 */
@EnableEurekaClient
@SpringBootApplication
@RestController
public class EurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServiceApplication.class, args);
	}
	
	@Value("${server.port}")
	private String port;
	
	@RequestMapping("/hi")
	public String home(String name){
	    return "hi " + name + ",I am from port:" + port;
	}
}
