package com.tom.sample.example.product;

import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

	public Product toProduct(ProductRequest request) {
		if (request == null) {
			throw new RuntimeException("");
		}

		return Product.builder().nome(request.nome())
				.quantidade(request.quantidade())
				.preco(request.preco())
				.fabricante(request.fabricante())
				.build();

	}

	public ProductResponse fromProduct(Product product) {
		return new ProductResponse(product.getId(), 
				product.getNome(), 
				product.getQuantidade(), 
				product.getPreco(),
				product.getFabricante(), 
				product.isAtivo()
			);
	}

}
