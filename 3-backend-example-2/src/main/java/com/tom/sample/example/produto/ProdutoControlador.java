package com.tom.sample.example.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.tom.sample.example.produto.swagger.ProdutoResposta;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/produto")
// @RequiredArgsConstructor
public class ProdutoControlador {

	@Autowired
	private ProductService service;
	
	// private final ProdutoServico service;

	@GetMapping("/buscar")
	public ResponseEntity<List<ProdutoResposta>> BuscarTodosProdutos() {
		var response = service.buscarTodosProdutos();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<ProdutoResposta> BuscarPorId(@PathVariable Long id) {
		var response = service.buscarProdutoPorId(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PostMapping("/criar")
	public ResponseEntity<ProdutoResposta> CriarProduto(@RequestBody @Valid ProductRequest request) {
		var response = service.criarProduto(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PutMapping("/editar/{id}")
	public ResponseEntity<Void> EditarProduto(@PathVariable Long id, @RequestBody @Valid ProductRequest request) {
		service.atualizarProduto(id, request);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}

	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Void> RemoverProduto(@PathVariable Long id) {
		service.removerProduto(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
