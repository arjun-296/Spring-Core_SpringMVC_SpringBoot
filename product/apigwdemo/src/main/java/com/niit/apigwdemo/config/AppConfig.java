package com.niit.apigwdemo.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    @Bean
    public RouteLocator getRoutes(RouteLocatorBuilder builder){
         return builder.routes()
                 .route(p->p.path("/productApp/v9/**").uri("http://localhost:5656/"))
                 .route(p->p.path("/userApp/v9/**").uri("http://localhost:5656/"))
                 .route(p->p.path("/auth/**").uri("http://localhost:7979/auth/"))
                 .build();
    }


}
