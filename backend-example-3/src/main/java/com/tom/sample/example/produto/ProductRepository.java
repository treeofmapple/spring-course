package com.tom.sample.example.produto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Produto, Long> {

	Optional<Produto> findByName(String name);

	boolean existsByName(String name);

	List<Produto> findByActiveTrueAndCreatedAtBefore(LocalDateTime date);
}
