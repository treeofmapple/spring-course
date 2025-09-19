package com.tom.sample.example.util;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tom.sample.example.produto.ProductRepository;
import com.tom.sample.example.produto.Produto;

import jakarta.validation.constraints.PositiveOrZero;

@Component
public class SystemStarts implements CommandLineRunner {

	@PositiveOrZero
	@Value("${application.quantity:30}")
	private static int QUANTITY = 30;

	@Value("${application.clean:true}")
	private static boolean CleanOnStart = true;

	@Autowired
	private GenerateData data;
	
	@Autowired
	private ProductRepository repository;

	public SystemStarts(GenerateData data, ProductRepository repository) {
		this.data = data;
		this.repository = repository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		if (CleanOnStart) {
			repository.deleteAll();
			List<Produto> produtos = IntStream.range(0, QUANTITY).mapToObj(i -> data.datagen()).toList();
			repository.saveAll(produtos);
		}
	}

}
