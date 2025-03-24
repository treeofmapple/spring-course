package com.tom.sample.example.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tom.sample.example.repository.LivrosRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SystemStarts implements CommandLineRunner {

	private static int QUANTITY = 30;
	
	private final GenerateData data;
	private final LivrosRepository repository;
	
    @Override
    public void run(String... args) throws Exception {
		for(int i = 0; i <= QUANTITY; i++) {
			var gen = data.datagen();
			repository.save(gen);
		}
	}
	
}
