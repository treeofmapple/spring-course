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
import lombok.NoArgsConstructor;

@Entity
@Data
// @Setter
// @Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "produto")
public class Produto {

	/*
	 * A escolha entre um tipo primitivo (int, long) e sua classe wrapper (Integer,
	 * Long) tem implicações diretas na flexibilidade e segurança do seu código.
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Identity
	private Long id;

	@Column(name = "nome")
	private String nome;
	
	@Column(name = "quantidade", nullable = true)
	private Integer quantidade;

	/*
	 * Tipos double e float são tipos de ponto flutuante binário (padrão IEEE 754).
	 * Isso significa que eles não conseguem representar com precisão todos os
	 * números decimais. Assim como a fração 1/3 vira uma dízima periódica em base
	 * 10 (0.333...), a fração 1/10 (ou 0.1) vira uma dízima periódica em base 2
	 * (binário).
	 * 
	 * Isso causa pequenos erros de arredondamento que são catastróficos para
	 * cálculos financeiros.
	 * 
	 */
	
	// Resultado esperado: 0.3
	// Resultado real: 0.30000000000000004

	/*
	 * BigDecimal é uma classe projetada para realizar cálculos com precisão decimal
	 * arbitrária. Ele armazena o valor internamente de uma forma que não perde a
	 * precisão decimal, tratando os números da mesma forma que nós os tratamos no
	 * papel.
	 */
	
	// Impacto em um Sistema Sensível (Banco, E-commerce)
	
	@Column(name = "preco", nullable = true)
	private BigDecimal preco;

	@Column(name = "fabricante", nullable = true)
	private String fabricante;

	
	/* Ele representa três estados. Diferente do Boolean
	 * 
	 * * True
	 * * False
	 * * Null
	 *  
	*/
	
	@Column(name = "ativo", nullable = true)
	private Boolean ativo;
	
}
