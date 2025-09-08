package com.tom.sample.example.produto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tom.sample.example.produto.swagger.ProdutoResposta;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoServico {

	private final ProdutoRepositorio repository;
	private final ProdutoMapeamento mapper;
	
	public ProdutoResposta buscarProdutoPorId(Long productId) {
		return repository.findById(productId).map(mapper::fromProduct).orElse(null);
	}

	public ProdutoResposta buscarProdutoPorNome(NomeRequer request) {
		return repository.findByNome(request.nome()).map(mapper::fromProduct).orElse(null);
	}

	public List<ProdutoResposta> buscarTodosProdutos() {
		List<Produto> product = repository.findAll();
		if(product.isEmpty()) {
			throw new RuntimeException("");
		}
		return product.stream().map(mapper::fromProduct).collect(Collectors.toList());
	}

	@Transactional
	public ProdutoResposta criarProduto(ProdutoRequer request) {
		if(repository.existsByNome(request.nome())) {
			throw new RuntimeException("");
		}
		
		var data = repository.save(mapper.toProduct(request));
		
		return mapper.fromProduct(data);
	}

	@Transactional
	public void atualizarProduto(long id, ProdutoRequer request) {
		var first = repository.findById(id).orElseThrow();
		var product = repository.findByNome(request.nome()).orElse(null);
		mesclarProduto(first, request);
		repository.save(product);
	}

	@Transactional
	public void removerProduto(long id /* NameRequest request */) {
		
		/*
		if(!repository.existsByNome(request.nome())) {
			throw new RuntimeException("");
		}
		var product = repository.findByNome(request.nome()).orElse(null);
		
		 */
		/*
		 * If the database query finds more than one product with the same name, Spring
		 * Data JPA will throw an IncorrectResultSizeDataAccessException because the
		 * result doesn't match the expected single-item return type.
		 */
		
		var removeProd = repository.findById(id).orElseThrow();
		repository.deleteById(removeProd.getId());
	}

	@Transactional
	public void ativarProduto(long id) {
		var product = repository.findById(id).orElseThrow();
		if(!product.isAtivo()) {
			product.setAtivo(true);
		} else {
			throw new RuntimeException("");
		}
		
	}

	private void mesclarProduto(Produto product, ProdutoRequer request) {
		product.setNome(request.nome());
		product.setPreco(request.preco());
		product.setQuantidade(request.quantidade());
		product.setFabricante(request.fabricante());
	}
	
}
