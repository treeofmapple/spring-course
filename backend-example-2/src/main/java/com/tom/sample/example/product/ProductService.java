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
		return repository.findByNome(request.nome()).map(mapper::fromProduct).orElse(null);
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
		
		return mapper.fromProduct(data);
	}

	@Transactional
	public void atualizarProduto(long id, ProductRequest request) {
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

	private void mesclarProduto(Product product, ProductRequest request) {
		product.setNome(request.nome());
		product.setPreco(request.preco());
		product.setQuantidade(request.quantidade());
		product.setFabricante(request.fabricante());
	}
	
}
