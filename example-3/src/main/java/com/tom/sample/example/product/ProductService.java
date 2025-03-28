package com.tom.sample.example.product;

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
public class ProductService {

	private final ProductRepository repository;
	private final SystemUtils systemUtils;
	private final ProductMapper mapper;
	
	public List<ProductResponse> findAllProducts() {
		List<Product> product = repository.findAll();
		if(product.isEmpty()) {
			throw new NotFoundException("");
		}
		return product.stream().map(mapper::fromProduct).collect(Collectors.toList());
	}
	
	@Cacheable(value = "products", key = "#productId")
	public ProductResponse findProductId(Long productId) {
		return repository.findById(productId)
				.map(mapper::fromProduct)
				.orElseThrow(() -> new NotFoundException(""));
	}

	@Cacheable(value = "products", key = "#request.name()")
	public ProductResponse findProductName(ProductNameRequest request) {
		return repository.findByName(request.name())
				.map(mapper::fromProduct)
				.orElseThrow(() -> new NotFoundException(""));
	}

	@Transactional
	@CachePut(value = "products", key = "#result.id")
	public ProductResponse createProduct(ProductRequest request) {
		if(repository.existsByName(request.name())) {
			throw new DuplicateException("");
		}
		
		var data = repository.save(mapper.toProduct(request));
		var response = mapper.fromProduct(data);
		
		return response;
	}

	@Transactional
	@CachePut(value = "products", key = "#request.name()")
	public void updateProduct(ProductRequest request) {
		var product = repository.findByName(request.name()).orElse(null);
		systemUtils.mergeData(product, request);
		repository.save(product);
	}

	@Transactional
	@CacheEvict(value = "products", key = "#request.name()")
	public void deleteProduct(ProductNameRequest request) {
		if(!repository.existsByName(request.name())) {
			throw new NotFoundException("");
		}
		repository.deleteByName(request.name());
	}

	@Transactional
	@CachePut(value = "products", key = "#request.name()")
	public void activateProduct(ProductNameRequest request) {
		var product = repository.findByName(request.name()).orElse(null);
		if(!product.isActive()) {
			product.setActive(true);
		} else {
			throw new DuplicateException("");
		}
		
	}

}
