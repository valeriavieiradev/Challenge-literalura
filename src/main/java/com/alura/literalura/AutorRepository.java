package com.alura.literalura;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    // Busca autor por nome ignorando maiúsculas/minúsculas
    Optional<Autor> findByNomeContainingIgnoreCase(String nome);

    // Busca autores vivos em um determinado ano (Regra do Trello)
    List<Autor> findByNascimentoLessThanEqualAndFalecimentoGreaterThanEqual(Integer ano, Integer ano2);
}