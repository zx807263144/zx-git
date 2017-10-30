package com.zx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
public class ServiceZipkinHiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceZipkinHiApplication.class, args);
	}
	
	private static final Logger LOGGER = LoggerFactory.getLogger( ServiceZipkinHiApplication.class );
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/hi")
	public String callHome(){
	    LOGGER.info( "calling trace service-zipkin-hi" );
	    return restTemplate.getForObject( "http://localhost:8771/miya", String.class );
	}
	
	@RequestMapping("/info")
	public String info(){
	    LOGGER.info( "calling trace service-zipkin-hi" );
	    return "I am service-zipkin-hi";
	}
	
	@Bean
	public AlwaysSampler alwaysSampler(){
	    return new AlwaysSampler();
	} 
	
	@Bean
	public RestTemplate restTemplate(){
	    return new RestTemplate();
	}
}
