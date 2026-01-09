package com.alura.literalura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	private LivroRepository livroRepo;

	@Autowired
	private AutorRepository autorRepo;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) {
		try {
			// Agora os nomes livroRepo e autorRepo são iguais aos lá de cima
			Cliente cliente = new Cliente(livroRepo, autorRepo);
			cliente.exibeMenu();
		} catch (Exception e) {
			System.out.println("Erro ao iniciar o menu: " + e.getMessage());
		}
	}
}