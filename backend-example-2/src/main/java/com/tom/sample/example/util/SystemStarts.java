package com.tom.sample.example.util;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tom.sample.example.produto.Produto;
import com.tom.sample.example.produto.ProdutoRepositorio;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SystemStarts implements CommandLineRunner {

	@PositiveOrZero
	@Value("${application.quantity:30}")
	private static int QUANTITY = 30;

	@Value("${application.clean:true}")
	private static boolean CleanOnStart = true;

	private final GenerateData data;
	private final ProdutoRepositorio repository;

	@Override
	public void run(String... args) throws Exception {
		if (CleanOnStart) {
			repository.deleteAll();
			List<Produto> produtos = IntStream.range(0, QUANTITY).mapToObj(i -> data.datagen()).toList();
			repository.saveAll(produtos);
		}
	}

}
