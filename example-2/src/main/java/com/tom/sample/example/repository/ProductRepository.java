package com.tom.sample.example.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tom.sample.example.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	Optional<Product> findByName(String name);

	boolean existsByName(String name);

	void deleteByName(String name);

	List<Product> findByActiveTrueAndDateCreatedBefore(LocalDateTime thirtyDaysAgo);

}
