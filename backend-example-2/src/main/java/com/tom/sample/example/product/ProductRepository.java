package com.tom.sample.example.product;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	Optional<Product> findByNome(String name);

	boolean existsByNome(String name);

	void deleteByNome(String name);

}
