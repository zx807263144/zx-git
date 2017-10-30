package com.zx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhongxin
 * @date 2017年9月6日
 * @description @EnableDiscoveryClient 和 @EnableEurekaClient  都可以向eureka服务中心注册，
 * 只是@EnableEurekaClient只能是eureka使用，@EnableDiscoveryClient其他的服务发现也可以使用，如（eureka, consul, zookeeper）
 * @EnableHystrix表示启用断路器hystrix
 * @EnableHystrixDashboard 开启hystrixDashboard
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
public class EurekaRibbonConsumeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaRibbonConsumeApplication.class, args);
	}
	
	/**
	 * @author zhongxin
	 * @date 2017年9月6日
	 * @description @LoadBalanced 表示该restTemplate开启负载均衡
	 * @return
	 */
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
	    return new RestTemplate();
	}
}
