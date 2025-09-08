package com.tom.sample.example.product;

import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

	public Produto toProduct(ProductRequest request) {
		if (request == null) {
			throw new RuntimeException("");
		}

		return Produto.builder().nome(request.name())
				.quantidade(request.quantity())
				.preco(request.price())
				.fabricante(request.manufacturer())
				.build();
	}

	public ProductResponse fromProduct(Produto product) {
		return new ProductResponse(product.getId(), 
				product.getNome(), 
				product.getQuantidade(), 
				product.getPreco(),
				product.getFabricante(), 
				product.isAtivo(), 
				product.getCreatedAt(), 
				product.getUpdatedAt());
	}

}
