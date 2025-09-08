package com.tom.sample.example.produto;

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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "produto")
public class Produto extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "quantidade", nullable = true)
	private int quantidade;
	
	@Column(name = "preco", nullable = true)
	private BigDecimal preco;

	@Column(name = "fabricante", nullable = true)
	private String fabricante;

	@Column(name = "ativo", nullable = true)
	private boolean ativo;
	
}
