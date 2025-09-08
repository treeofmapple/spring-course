package com.tom.sample.example.produto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.tom.sample.example.exception.DuplicateException;
import com.tom.sample.example.exception.NotFoundException;
import com.tom.sample.example.util.SystemUtils;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoService {

	private final ProductRepository repository;
	private final SystemUtils systemUtils;
	private final ProductMapper mapper;
	
	public List<ProdutoResponse> findAllProducts() {
		List<Produto> product = repository.findAll();
		if(product.isEmpty()) {
			throw new NotFoundException("");
		}
		return product.stream().map(mapper::fromProduct).collect(Collectors.toList());
	}
	
	public ProdutoResponse findProductId(Long productId) {
		return repository.findById(productId)
				.map(mapper::fromProduct)
				.orElseThrow(() -> new NotFoundException(""));
	}

	public ProdutoResponse findProductName(ProductNameRequest request) {
		return repository.findByName(request.name())
				.map(mapper::fromProduct)
				.orElseThrow(() -> new NotFoundException(""));
	}

	@Transactional
	public ProdutoResponse createProduct(ProductRequest request) {
		if(repository.existsByName(request.name())) {
			throw new DuplicateException("");
		}
		
		var data = repository.save(mapper.toProduct(request));
		var response = mapper.fromProduct(data);
		
		return response;
	}

	@Transactional
	public void updateProduct(EditRequest request) {
		var product = repository.findByName(request.product().name()).orElse(null);
		systemUtils.mergeData(product, request.request());
		repository.save(product);
	}

	@Transactional
	public void deleteProduct(ProductNameRequest request) {
		if(!repository.existsByName(request.name())) {
			throw new NotFoundException("");
		}
		repository.deleteByName(request.name());
	}

	@Transactional
	public void activateProduct(ProductNameRequest request) {
		var product = repository.findByName(request.name()).orElse(null);
		if(!product.isActive()) {
			product.setActive(true);
		} else {
			throw new DuplicateException("");
		}
		
	}

}
