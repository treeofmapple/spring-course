package com.tom.sample.example.produto;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {

	Optional<Produto> findByNome(String name);

	boolean existsByNome(String name);

}
