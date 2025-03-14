package com.tom.sample.example.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tom.sample.example.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SystemStarts implements CommandLineRunner {

	private final GenerateData data;
	private final ProductRepository repository;
	
    @Override
    public void run(String... args) throws Exception {
		for(int i = 0; i <= 30; i++) {
			var gen = data.datagen();
			repository.save(gen);
		}
	}
	
}


