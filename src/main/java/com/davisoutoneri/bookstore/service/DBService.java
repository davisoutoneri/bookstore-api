package com.davisoutoneri.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davisoutoneri.bookstore.domain.Categoria;
import com.davisoutoneri.bookstore.domain.Livro;
import com.davisoutoneri.bookstore.repositories.CategoriaRepository;
import com.davisoutoneri.bookstore.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

	public void instanciaBaseDeDados() {

		Categoria categoria1 = new Categoria(null, "Informática", "Livros de TI");
		Categoria categoria2 = new Categoria(null, "Ficção Científica", "Livros fantasias científicas");
		Categoria categoria3 = new Categoria(null, "Biografias", "Livros sobre a vida de uma pessoa");

		Livro livro1 = new Livro(null, "Clean Code", "Robert Martin", "Lore Impsum", categoria1);
		Livro livro2 = new Livro(null, "Engenharia de Software", "Louis V. Gerstner", "Lore Impsum", categoria1);
		Livro livro3 = new Livro(null, "The Time Machine", "H.G Wells", "Lore Impsum", categoria2);
		Livro livro4 = new Livro(null, "The War of the Worlds", "H.G Wells", "Lore Impsum", categoria2);
		Livro livro5 = new Livro(null, "I, Robot", "H.G Wells", "Lore Impsum", categoria2);
		Livro livro6 = new Livro(null, "André Luis", "Chico Xavier", "Lore Impsum", categoria3);

		categoria1.getLivros().addAll(Arrays.asList(livro1, livro2));
		categoria2.getLivros().addAll(Arrays.asList(livro3, livro4, livro5));
		categoria3.getLivros().addAll(Arrays.asList(livro6));

		this.categoriaRepository.saveAll(Arrays.asList(categoria1,categoria2,categoria3));
		this.livroRepository.saveAll(Arrays.asList(livro1,livro2,livro3,livro4,livro5,livro6));
	}

}
