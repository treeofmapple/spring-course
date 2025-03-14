package com.tom.sample.example.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "livros")
public class Livros {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "title", nullable = false, unique = true)
	private String title;
	
	@Column(name = "author", nullable = false)
	private String author;
	
	@Column(name = "book_date", nullable = false)
	private LocalDate bookDate;

	@JsonIgnore // Prevents recieving data from API requests
	@Column(name = "date_created", nullable = false, updatable = false)
	private LocalDateTime dateCreated;
	
    @JsonProperty("dateCreated")
    public LocalDateTime getDateCreated() {
        return dateCreated;
    }
	
    @PrePersist
    private void prePersist() {
        this.dateCreated = LocalDateTime.now();
    }
}
