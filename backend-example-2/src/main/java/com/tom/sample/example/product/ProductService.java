package com.tom.sample.example.product;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository repository;
	private final ProductMapper mapper;
	
	public ProductResponse buscarProdutoPorId(Long productId) {
		return repository.findById(productId).map(mapper::fromProduct).orElse(null);
	}

	public ProductResponse buscarProdutoPorNome(NameRequest request) {
		return repository.findByNome(request.name()).map(mapper::fromProduct).orElse(null);
	}

	public List<ProductResponse> buscarTodosProdutos() {
		List<Product> product = repository.findAll();
		if(product.isEmpty()) {
			throw new RuntimeException("");
		}
		return product.stream().map(mapper::fromProduct).collect(Collectors.toList());
	}

	@Transactional
	public ProductResponse criarProduto(ProductRequest request) {
		if(repository.existsByNome(request.nome())) {
			throw new RuntimeException("");
		}
		
		var data = repository.save(mapper.toProduct(request));
		var response = mapper.fromProduct(data);
		
		return response;
	}

	@Transactional
	public void atualizarProduto(ProductRequest request) {
		var product = repository.findByNome(request.nome()).orElse(null);
		mesclarProduto(product, request);
		repository.save(product);
	}

	@Transactional
	public void removerProduto(NameRequest request) {
		if(!repository.existsByNome(request.name())) {
			throw new RuntimeException("");
		}
		repository.deleteByNome(request.name());
	}

	@Transactional
	public void ativarProduto(NameRequest request) {
		var product = repository.findByNome(request.name()).orElse(null);
		if(!product.isAtivo()) {
			product.setAtivo(true);
		} else {
			throw new RuntimeException("");
		}
		
	}

	private void mesclarProduto(Product product, ProductRequest request) {
		product.setNome(request.nome());
		product.setPreco(request.preco());
		product.setQuantidade(request.quantidade());
		product.setFabricante(request.fabricante());
	}
	
}
