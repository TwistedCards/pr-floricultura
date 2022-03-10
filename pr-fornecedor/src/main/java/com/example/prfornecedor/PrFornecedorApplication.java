package com.example.prfornecedor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
//@EnableResourceServer
@SpringBootApplication
public class PrFornecedorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrFornecedorApplication.class, args);
	}

}
