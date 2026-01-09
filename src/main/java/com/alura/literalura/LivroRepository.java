package com.alura.literalura;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    // Busca livros por idioma (Regra do Trello)
    List<Livro> findByIdioma(String idioma);
}