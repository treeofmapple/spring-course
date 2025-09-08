package com.tom.sample.example.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tom.sample.example.produto.swagger.ProdutoResposta;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/spec")
// @RequiredArgsConstructor
public class OutroControlador {

	@Autowired
	private ProdutoServico service;
	
	// private final ProdutoServico service;

	@GetMapping("/buscar/produto")
	public ResponseEntity<ProdutoResposta> buscarProdutoPeloNome(@RequestBody @Valid NomeRequer request) {
		var response = service.buscarProdutoPorNome(request);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PutMapping("/ativar/{id}")
	public ResponseEntity<Void> ativarProduto(@PathVariable long id) {
		service.ativarProduto(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
