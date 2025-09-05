package com.tom.sample.example.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class OtherController {

	private final ProductService service;

	@GetMapping("/get/product")
	public ResponseEntity<ProductResponse> buscarProdutoPeloNome(@RequestBody @Valid NameRequest request) {
		var response = service.buscarProdutoPorNome(request);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PutMapping("/activate")
	public ResponseEntity<Void> ativarProduto(@RequestBody @Valid NameRequest request) {
		service.ativarProduto(request);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
