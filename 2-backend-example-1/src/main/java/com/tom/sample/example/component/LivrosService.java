package com.tom.sample.example.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tom.sample.example.model.Livros;
import com.tom.sample.example.repository.LivrosRepository;

/*
 * Specialization of the component more focused on serving a function
 * like book service, focused on doing book functions or handling 
 * book operations, getting all books data, creating or finding
 * 
 * */ 

@Service
public class LivrosService {

	@Autowired
	private LivrosRepository repository;

    public Livros createLivro(String book) {
        return repository.save(new Livros(null, book, null, null)); // Please don't do this
    }
	
}
