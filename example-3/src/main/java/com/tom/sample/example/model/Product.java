package com.tom.sample.example.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(
	name = "product",
		indexes = {
		        @Index(name = "idx_productname", columnList = "product_name")
		    },
		    uniqueConstraints = {
		        @UniqueConstraint(name = "uq_productname", columnNames = "product_name")
	    }
	)
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "product_name", nullable = false, unique = false)
	private String name;

	@Column(name = "quantity", nullable = true, unique = false)
	private int quantity;
	
	@Column(name = "price", nullable = true, unique = false)
	private BigDecimal price;

	@Column(name = "manufacturer", nullable = true, unique = false)
	private String manufacturer;

	@Column(name = "active", nullable = true, unique = false)
	private boolean active;
	
	@Column(name = "last_update", nullable = false, updatable = false)
	private LocalDateTime lastUpdated;

	@Column(name = "date_created", nullable = false, updatable = false)
	private LocalDateTime dateCreated;

	@PrePersist
	private void prePersist() {
		this.dateCreated = LocalDateTime.now();
		this.lastUpdated = LocalDateTime.now();
		this.active = true;
	}

	@PreUpdate
	private void preUpdate() {
		this.lastUpdated = LocalDateTime.now();
	}

}
