package com.tom.sample.example.product;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nome", nullable = false, unique = false)
	private String nome;

	@Column(name = "quantidade", nullable = true, unique = false)
	private int quantidade;
	
	@Column(name = "preco", nullable = true, unique = false)
	private BigDecimal preco;

	@Column(name = "fabricante", nullable = true, unique = false)
	private String fabricante;

	@Column(name = "ativo", nullable = true, unique = false)
	private boolean ativo;
	
}
