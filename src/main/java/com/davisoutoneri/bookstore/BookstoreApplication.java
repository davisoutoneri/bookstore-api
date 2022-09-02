package com.davisoutoneri.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.davisoutoneri.bookstore.domain.Categoria;
import com.davisoutoneri.bookstore.domain.Livro;
import com.davisoutoneri.bookstore.repositories.CategoriaRepository;
import com.davisoutoneri.bookstore.repositories.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;


	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria categoria1 = new Categoria(null, "Informática", "Livro de TI");
		
		Livro livro1 = new Livro(null, "Clean Code", "Robert Martin", "Lore Impsum", categoria1);
		
		categoria1.getLivros().addAll(Arrays.asList(livro1));
		
		this.categoriaRepository.saveAll(Arrays.asList(categoria1));
		this.livroRepository.saveAll(Arrays.asList(livro1));
		
	}
	

}
