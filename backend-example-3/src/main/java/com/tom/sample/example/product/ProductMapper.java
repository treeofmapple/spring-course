package com.tom.sample.example.product;

import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

	public Produto toProduct(ProductRequest request) {
		if (request == null) {
			return null;
		}

		return Produto.builder().name(request.name()).quantity(request.quantity()).price(request.price())
				.manufacturer(request.manufacturer()).build();

	}

	public ProductResponse fromProduct(Produto product) {
		return new ProductResponse(product.getId(), product.getName(), product.getQuantity(), product.getPrice(),
				product.getManufacturer(), product.isActive(), product.getCreatedAt(), product.getUpdatedAt());
	}

}
