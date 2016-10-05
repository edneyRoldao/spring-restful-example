package com.edn.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.edn")
public class AppConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/*").
		allowedOrigins("*").
		allowedHeaders("").
		allowedMethods("DELETE", "POST", "PUT", "OPTIONS", "GET", "HEAD").
		allowCredentials(true);
		// http://dontpanic.42.nl/2015/04/cors-with-spring-mvc.html
	}
	
}
