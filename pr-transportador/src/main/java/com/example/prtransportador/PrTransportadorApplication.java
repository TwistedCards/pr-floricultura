package com.example.prtransportador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PrTransportadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrTransportadorApplication.class, args);
	}

}
