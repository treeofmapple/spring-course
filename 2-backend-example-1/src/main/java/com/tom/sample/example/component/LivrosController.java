package com.tom.sample.example.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("unused")
@RestController
// This controller is focused on returning data
// Or building REST APIs. It returns data, like JSON or XML.

// @RequestMapping("/v1/livros")
public class LivrosController {

	@Autowired
	private LivrosService service;
	
	// @GetMapping("")
	// @PostMapping("")
	// @PutMapping("")
	// @DeleteMapping(value = "")
	// @PatchMapping(value = "")
	
	@GetMapping(value = "/{value}")
	public ResponseEntity<?> buscarObjeto(@PathVariable("value") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	@GetMapping(value = "/2")
	public ResponseEntity<?> buscarObjeto2(@RequestBody Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	public ResponseEntity<?> buscarObjeto() {
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
}

