package com.paru.enterprices.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@ComponentScan(basePackages = {"com.paru.enterprices.admin", 
		"com.paru.enterprices.services", 
		"com.paru.enterprices.database", "com.paru.enterprices.idp"})
@SpringBootApplication
@EntityScan(basePackages={"com.paru.enterprices.database"})
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	 @Bean
	 public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurerAdapter() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/**").allowedMethods("*").allowedOrigins("http://localhost:4200");
	            }
	        };
	 }

}
