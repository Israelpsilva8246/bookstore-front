package com.israel.bookstorebackend;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.israel.bookstorebackend.domain.Categoria;
import com.israel.bookstorebackend.domain.Livro;
import com.israel.bookstorebackend.repository.CategoriaRepository;
import com.israel.bookstorebackend.repository.LivroRepository;

@SpringBootApplication
public class BookstoreBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreBackendApplication.class, args);
	}


}
