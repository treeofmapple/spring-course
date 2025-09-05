package com.tom.sample.example.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "livros")
public class Livros {

	@Id
	@GeneratedValue
	private Long id;

	private String titulo;
	
	private String autor;
	
	private LocalDate dataLivro;

}