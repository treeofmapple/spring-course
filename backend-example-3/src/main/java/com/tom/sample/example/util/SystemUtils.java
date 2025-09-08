package com.tom.sample.example.util;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.tom.sample.example.produto.ProductRepository;
import com.tom.sample.example.produto.ProductRequest;
import com.tom.sample.example.produto.Produto;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SystemUtils {

	private final ProductRepository repository;
	
	public void mergeData(Produto product, ProductRequest request) {
		product.setNome(request.name());
		product.setPreco(request.price());
		product.setQuantidade(request.quantity());
		product.setFabricante(request.manufacturer());
	}
	
	@Transactional
    @Scheduled(cron = "0 0 0 * * ?")
    public void deactivateOldProducts() {
        LocalDateTime thirtyDaysAgo = LocalDateTime.now().minusDays(30);
        List<Produto> oldProducts = repository.findByActiveTrueAndCreatedAtBefore(thirtyDaysAgo);

        for (Produto product : oldProducts) {
            product.setAtivo(false);
        }

        repository.saveAll(oldProducts);
        System.out.println("Deactivated " + oldProducts.size() + " old products.");
    }
	
}
