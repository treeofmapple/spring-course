package com.tom.sample.example.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "livros") // , schema = "dataschema1")
public class Livros {
	
	public Livros() {
	}
	
	public Livros(Long id, String titulo, String autor, LocalDate dataLivro) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.dataLivro = dataLivro;
	}

	/*
	 * A escolha entre um tipo primitivo (int, long) e sua classe wrapper (Integer,
	 * Long) tem implicações diretas na flexibilidade e segurança do seu código.
	 * 
	 */
	
	@Id
	@GeneratedValue() 
	// Your custom generator or the one mapped by the database
	// Gerador de chave primaria.
	// (strategy = GenerationType.AUTO) Identity
	
	/* Identity
	 * Delega a responsabilidade de gerar e gerenciar 
	 * o ID diretamente para a coluna de auto-incremento do banco de dados.
	 */
	
	/*
	 * * Sequence = utiliza um objeto para gerar as ids. 
	 * 
	 * * Auto = deixa o provedor escolher a melhor estrategia. 
	 * 
	 * * Table = Simula uma sequence usando uma tabela
	 * separada no banco de dados para controlar os valores dos IDs.
	 * 
	 */
	
	private Long id;

	@Column(name = "titulo", 
			nullable = true, 
			updatable = true, 
			unique = false)
	private String titulo;
	
	private String autor;
	
	private LocalDate dataLivro;

	// @Column(precision = 15, scale = 2)
	// private BigDecimal salary;
	
	//  999,999,999,999.99
	
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

	@Transient
	private BigDecimal preco;
	
	/* Ele representa três estados. Diferente do Boolean
	 * 
	 * * True
	 * * False
	 * * Null
	 *  
	*/
	
	@Transient
	private Boolean Ativo;
	
	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public LocalDate getDataLivro() {
		return dataLivro;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setDataLivro(LocalDate dataLivro) {
		this.dataLivro = dataLivro;
	}
	
}