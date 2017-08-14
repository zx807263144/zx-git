package com.zx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackgroundAssemblyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackgroundAssemblyApplication.class, args);
		System.out.println( "background-assembly run" );
	}
}
