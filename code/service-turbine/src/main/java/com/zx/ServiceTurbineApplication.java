package com.zx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author zhongxin
 * @date 2017年9月18日
 * @description @EnableTurbine 开启hystrixTurbine服务
 */
@EnableTurbine
@SpringBootApplication
public class ServiceTurbineApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceTurbineApplication.class, args);
	}
}
