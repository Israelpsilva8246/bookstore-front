package com.israel.crudspring;

import com.israel.crudspring.model.Cliente;
import com.israel.crudspring.repository.ClienteRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initialDatabase(ClienteRepository clienteRepository) {
		return args -> {
			clienteRepository.deleteAll();
			Cliente c = new Cliente();
			c.setNome("Israel");
			c.setSobrenome("Pontes");
			c.setIdade("20");
			clienteRepository.save(c);
		};
	}

}
