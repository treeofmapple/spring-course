package com.tom.sample.example.produto;

import org.springframework.stereotype.Service;

import com.tom.sample.example.produto.swagger.ProdutoResposta;

@Service
public class ProdutoMapeamento {

	public Produto toProduct(ProdutoRequer request) {
		if (request == null) {
			throw new RuntimeException("");
		}

		return Produto.builder().nome(request.nome())
				.quantidade(request.quantidade())
				.preco(request.preco())
				.fabricante(request.fabricante())
				.build();

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
