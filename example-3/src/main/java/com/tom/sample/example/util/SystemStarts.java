package com.tom.sample.example.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Component;

import com.tom.sample.example.product.Product;
import com.tom.sample.example.product.ProductRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SystemStarts implements CommandLineRunner {

	private static int QUANTITY = 30;
	
	private final GenerateData data;
	private final ProductRepository repository;
	
    @Override
    public void run(String... args) throws Exception {
		for(int i = 0; i <= QUANTITY; i++) {
			var gen = data.datagen();
			repository.save(gen);
		}
	}
	
    @CachePut(value = "products", key = "#product.id")
    public Product cacheProduct(Product product) {
        return product;
    }
    
}

