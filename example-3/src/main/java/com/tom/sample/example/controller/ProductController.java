package com.tom.sample.example.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tom.sample.example.dto.ProductNameRequest;
import com.tom.sample.example.dto.ProductRequest;
import com.tom.sample.example.dto.ProductResponse;
import com.tom.sample.example.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService service;

	@GetMapping(value = "/get")
	public ResponseEntity<List<ProductResponse>> getAllProduct() {
		var response = service.findAllProducts();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<ProductResponse> getProductId(@PathVariable Long id) {
		var response = service.findProductId(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping(value = "/get/product")
	public ResponseEntity<ProductResponse> getProductName(@RequestBody @Valid ProductNameRequest request) {
		var response = service.findProductName(request);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PostMapping(value = "/create")
	public ResponseEntity<ProductResponse> createProduct(@RequestBody @Valid ProductRequest request) {
		var response = service.createProduct(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PutMapping(value = "/edit")
	public ResponseEntity<Void> editProduct(@RequestBody @Valid ProductRequest request) {
		service.updateProduct(request);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}

	@DeleteMapping(value = "/delete")
	public ResponseEntity<Void> deleteProduct(@RequestBody @Valid ProductNameRequest request) {
		service.deleteProduct(request);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PutMapping(value = "/activate")
	public ResponseEntity<Void> activateProduct(@RequestBody @Valid ProductNameRequest request) {
		service.activateProduct(request);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
}
