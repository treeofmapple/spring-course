package com.tom.sample.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tom.sample.example.model.Livros;

@RepositoryRestResource(collectionResourceRel = "livros", path = "livros")
public interface LivrosRepository extends JpaRepository<Livros, Long> {

}
