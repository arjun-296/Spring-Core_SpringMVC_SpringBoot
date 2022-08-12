package com.example.authenticationWithRest;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AuthenticationWithRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationWithRestApplication.class,
				args);
	}


}
