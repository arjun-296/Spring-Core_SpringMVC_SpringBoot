package com.niit.Rest_mongo_Product;

import com.niit.Rest_mongo_Product.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class RestMongoProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestMongoProductApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean JwtFilter() {

		FilterRegistrationBean fr= new FilterRegistrationBean();
		fr.setFilter(new JwtFilter());
		fr.addUrlPatterns("/productApp/v9/*");
		return fr;
	}

}
