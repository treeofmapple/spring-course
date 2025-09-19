package com.tom.sample.example.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/*
 * Focused on importing external libraries, or configuring external libs
 * Like kafka or rabbitmq
 * Or S3Client or what is called more S3 Bucket aws
 * Or expecific configurations, for authentication, an example
 * is setting the password configurator, for the level of authentication.
*/
@Configuration
public class LivrosConfiguration {

	@Bean
	public void runningExample() {
		
	}

	/*
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); 
        // Default is 12 you can set it on the values you wanna
        /// depending on the project configuration. 
    }
    
	*/
}
