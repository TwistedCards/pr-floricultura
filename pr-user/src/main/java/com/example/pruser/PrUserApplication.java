package com.example.pruser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableEurekaClient
@SpringBootApplication
public class PrUserApplication implements CommandLineRunner {
	
	@Autowired
	private BCryptPasswordEncoder password;
	
	public static void main(String[] args) {
		SpringApplication.run(PrUserApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Bcrypt: " + password.encode("123"));
	}
	
}
