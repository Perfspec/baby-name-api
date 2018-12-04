package com.infosys.babynameapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BabyNameApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BabyNameApiApplication.class, args);
	}
	
	@Bean
    public RestTemplate getRestTemplate() {
       return new RestTemplate();
    }
}
