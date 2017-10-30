package com.zx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

/**
 * @author zhongxin
 * @date 2017年9月14日
 * @description @EnableZipkinServer 启用ZipkinServer功能
 */
@EnableZipkinServer
@SpringBootApplication
public class ServerZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerZipkinApplication.class, args);
	}
}
