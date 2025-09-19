package com.tom.sample.example.produto;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {

	public Produto() {
	}
	
	public Produto(Long id, String nome, Integer quantidade, BigDecimal preco, String fabricante, Boolean ativo) {
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
		this.fabricante = fabricante;
		this.ativo = ativo;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	private String nome;
	
	@Column(name = "quantidade", nullable = true)
	private Integer quantidade;

	@Column(name = "preco", nullable = true)
	private BigDecimal preco;

	@Column(name = "fabricante", nullable = true)
	private String fabricante;

	@Column(name = "ativo", nullable = true)
	private Boolean ativo;
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getFabricante() {
		return fabricante;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
}
