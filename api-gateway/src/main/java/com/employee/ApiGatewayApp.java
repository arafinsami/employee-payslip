package com.employee;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@EnableEurekaClient
@SpringBootApplication
public class ApiGatewayApp {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApp.class, args);
	}

	@Bean
	public CorsWebFilter corsWebFilter() {
		CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.setAllowedOrigins(Arrays.asList("*"));
		corsConfig.setMaxAge(8000L);
		corsConfig.addAllowedMethod("*");
		corsConfig.addAllowedHeader("*");
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfig);
		return new CorsWebFilter(source);
	}
}
