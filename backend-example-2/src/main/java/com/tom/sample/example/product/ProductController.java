package com.tom.sample.example.product;

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

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/product")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService service;

	@GetMapping("/get")
	public ResponseEntity<List<ProductResponse>> BuscarTodosProdutos() {
		var response = service.buscarTodosProdutos();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<ProductResponse> BuscarPorId(@PathVariable long id) {
		var response = service.buscarProdutoPorId(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PostMapping("/create")
	public ResponseEntity<ProductResponse> CriarProduto(@RequestBody @Valid ProductRequest request) {
		var response = service.criarProduto(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<Void> EditarProduto(@PathVariable long id, @RequestBody @Valid ProductRequest request) {
		service.atualizarProduto(id, request);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> RemoverProduto(@PathVariable long id) {
		service.removerProduto(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
