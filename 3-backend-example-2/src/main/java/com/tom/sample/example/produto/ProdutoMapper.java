package com.tom.sample.example.produto;

import org.springframework.stereotype.Service;

import com.tom.sample.example.produto.swagger.ProdutoResposta;

@Service
public class ProdutoMapper {

	public Produto toProduct(ProductRequest request) {
		if (request == null) {
			throw new RuntimeException("");
		}

		Produto produto = new Produto();
		produto.setNome(request.nome());
		produto.setQuantidade(request.quantidade());
		produto.setPreco(request.preco());
		produto.setFabricante(request.fabricante());
		return produto;
	}

	public ProdutoResposta fromProduct(Produto product) {
		return new ProdutoResposta(product.getId(), 
				product.getNome(), 
				product.getQuantidade(), 
				product.getPreco(),
				product.getFabricante(), 
				product.getAtivo()
			);
	}

}
