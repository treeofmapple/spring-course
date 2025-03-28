package com.tom.sample.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Example3Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Example3Application.class, args);
	}

}
