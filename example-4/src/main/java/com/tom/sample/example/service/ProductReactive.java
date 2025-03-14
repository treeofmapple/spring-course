package com.tom.sample.example.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.tom.sample.example.dto.ProductNameRequest;
import com.tom.sample.example.dto.ProductRequest;
import com.tom.sample.example.dto.ProductResponse;
import com.tom.sample.example.exception.DuplicateException;
import com.tom.sample.example.exception.NotFoundException;
import com.tom.sample.example.mapper.SystemMapper;
import com.tom.sample.example.model.Product;
import com.tom.sample.example.repository.ProductRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductReactive {

	private final ProductRepository repository;
	private final SystemMapper mapper;

	@Cacheable(value = "products", key = "#productId")
	public Mono<ProductResponse> getProductById(Long id){
		return Mono.justOrEmpty(repository.findById(id).map(mapper::buildResponse));
	}
	
    @Cacheable(value = "products", key = "#request.name()")
    public Mono<ProductResponse> getProductName(ProductNameRequest request) {
        return Mono.justOrEmpty(repository.findByName(request.name()))
                   .map(mapper::buildResponse);
    }
	
    public Flux<ProductResponse> getAllProduct() {
        return Flux.fromIterable(repository.findAll())
                   .map(mapper::buildResponse)
                   .switchIfEmpty(Flux.error(new NotFoundException("No products found")));
    }
	
    @Transactional
    @CachePut(value = "products", key = "#result.id")
    public Mono<ProductResponse> createProduct(ProductRequest request) {
        if (repository.existsByName(request.name())) {
            return Mono.error(new DuplicateException("Product already exists"));
        }

        return Mono.fromCallable(() -> repository.save(mapper.buildAttributes(request)))
                   .map(mapper::buildResponse);
    }
    
    @Transactional
    @CachePut(value = "products", key = "#request.name()")
    public Mono<Void> updateProduct(ProductRequest request) {
        return Mono.justOrEmpty(repository.findByName(request.name()))
                   .switchIfEmpty(Mono.error(new NotFoundException("Product not found")))
                   .doOnNext(product -> mergerData(product, request))
                   .flatMap(product -> Mono.fromCallable(() -> repository.save(product)))
                   .then();
    }
    
    @Transactional
    @CacheEvict(value = "products", key = "#request.name()")
    public Mono<Void> deleteProduct(ProductNameRequest request) {
        if (!repository.existsByName(request.name())) {
            return Mono.error(new NotFoundException("Product not found"));
        }
        return Mono.fromRunnable(() -> repository.deleteByName(request.name()))
                   .then();
    }
    
    @Transactional
    @CachePut(value = "products", key = "#request.name()")
    public Mono<Void> activateProduct(ProductNameRequest request) {
        return Mono.justOrEmpty(repository.findByName(request.name()))
                   .switchIfEmpty(Mono.error(new NotFoundException("Product not found")))
                   .flatMap(product -> {
                       if (!product.isActive()) {
                           product.setActive(true);
                           return Mono.fromCallable(() -> repository.save(product)).then();
                       } else {
                           return Mono.error(new DuplicateException("Product already active"));
                       }
                   });
    }
    
    private void mergerData(Product product, ProductRequest request) {
        product.setName(request.name());
        product.setPrice(request.price());
        product.setQuantity(request.quantity());
        product.setManufacturer(request.manufacturer());
    }
}
