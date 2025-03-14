package com.tom.sample.example.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.scheduling.annotation.Scheduled;
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

// @Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository repository;
	private final SystemMapper mapper;
	
	public ProductResponse findProductId(Long productId) {
		// log.info("Searching for product: {}", productId);
		return repository.findById(productId).map(mapper::buildResponse).orElse(null);
	}

	public ProductResponse findProductName(ProductNameRequest request) {
		return repository.findByName(request.name()).map(mapper::buildResponse).orElse(null);
	}

	public List<ProductResponse> findAllProducts() {
		List<Product> product = repository.findAll();
		if(product.isEmpty()) {
			throw new NotFoundException("");
		}
		return product.stream().map(mapper::buildResponse).collect(Collectors.toList());
	}

	@Transactional
	public ProductResponse createProduct(ProductRequest request) {
		if(repository.existsByName(request.name())) {
			throw new DuplicateException("");
		}
		
		var data = repository.save(mapper.buildAttributes(request));
		var response = mapper.buildResponse(data);
		
		return response;
	}

	@Transactional
	public void updateProduct(ProductRequest request) {
		var product = repository.findByName(request.name()).orElse(null);
		mergerData(product, request);
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

	private void mergerData(Product product, ProductRequest request) {
		product.setName(request.name());
		product.setPrice(request.price());
		product.setQuantity(request.quantity());
		product.setManufacturer(request.manufacturer());
	}
	
	//@Scheduled(fixedDelay = 1)
    @Scheduled(cron = "0 0 0 * * ?")
    @Transactional
    public void deactivateOldProducts() {
        LocalDateTime thirtyDaysAgo = LocalDateTime.now().minusDays(30);
        List<Product> oldProducts = repository.findByActiveTrueAndDateCreatedBefore(thirtyDaysAgo);

        for (Product product : oldProducts) {
            product.setActive(false);
        }

        repository.saveAll(oldProducts);
        System.out.println("Deactivated " + oldProducts.size() + " old products.");
    }
	
}
