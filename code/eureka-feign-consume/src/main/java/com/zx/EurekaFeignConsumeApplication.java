package com.zx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author zhongxin
 * @date 2017年9月8日
 * @description @EnableDiscoveryClient 向服务注册中心注册服务
 * @EnableFeignClients 启用feign
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaFeignConsumeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaFeignConsumeApplication.class, args);
	}
}
