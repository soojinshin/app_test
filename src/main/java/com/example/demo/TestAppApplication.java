package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@SpringBootApplication
public class TestAppApplication {

	
/*	@Bean
	public MappingJackson2HttpMessageConverter converter(){
		return new MappingJackson2HttpMessageConverter();
		
	}
	*/

	public static void main(String[] args) {
		
		
		SpringApplication.run(TestAppApplication.class, args);
	
	}
	
	
	
}
