package com.tom.sample.example.util;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tom.sample.example.repository.LivrosRepository;

@Component
public class SystemStarts implements CommandLineRunner {

	private static int QUANTITY = 30;

	@Autowired
	private GenerateData data;

	@Autowired
	private LivrosRepository repository;

	public SystemStarts(GenerateData data, LivrosRepository repository) {
		this.data = data;
		this.repository = repository;
	}

	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();
		var entities = IntStream.rangeClosed(1, QUANTITY).mapToObj(i -> data.datagen()).toList();
		repository.saveAll(entities);
	}

}
