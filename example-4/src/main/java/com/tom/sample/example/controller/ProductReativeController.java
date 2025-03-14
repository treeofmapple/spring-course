package com.tom.sample.example.controller;

import org.springframework.http.MediaType;
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
import com.tom.sample.example.service.ProductReactive;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v2")
@RequiredArgsConstructor
public class ProductReativeController {

	private final ProductReactive reactive;
	
    @GetMapping(value = "/get/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<ProductResponse> getProductById(@PathVariable Long id) {
        return reactive.getProductById(id);
    }

    @GetMapping(value = "/get", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ProductResponse> getAllProducts() {
        return reactive.getAllProduct();
    }

    @PostMapping(value = "/insert", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<ProductResponse> createProduct(@RequestBody @Valid ProductRequest request) {
        return reactive.createProduct(request);
    }

    @PutMapping(value = "/edit", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<Void> editProduct(@RequestBody @Valid ProductRequest request) {
        return reactive.updateProduct(request);
    }

    @DeleteMapping(value = "/delete", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<Void> deleteProduct(@RequestBody @Valid ProductNameRequest request) {
        return reactive.deleteProduct(request);
    }

    @PutMapping(value = "/activate", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<Void> activateProduct(@RequestBody @Valid ProductNameRequest request) {
        return reactive.activateProduct(request);
    }
	
}
