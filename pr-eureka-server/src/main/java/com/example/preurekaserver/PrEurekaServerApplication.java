package com.example.preurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class PrEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrEurekaServerApplication.class, args);
	}

}
