package com.alura.literalura;

import jakarta.persistence.*;
import java.util.List;

@Entity // Isso avisa ao Spring que esta classe é uma tabela no Postgres
@Table(name = "autores") // Dá o nome para a tabela
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Chave primária (ID automático)

    private String nome;
    private Integer nascimento;
    private Integer falecimento;

    // Relacionamento: Um autor pode ter vários livros
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Livro> livros;

    // Construtor vazio (obrigatório para o Banco de Dados funcionar)
    public Autor() {}

    // Construtor para transformar os dados que vêm da API em um objeto do Banco
    public Autor(DadosAutor dadosAutor) {
        this.nome = dadosAutor.nome();
        this.nascimento = dadosAutor.anoNascimento();
        this.falecimento = dadosAutor.anoFalecimento();
    }

    // Getters e Setters (as "portas" para ler e escrever os dados)
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public Integer getNascimento() { return nascimento; }
    public Integer getFalecimento() { return falecimento; }

    @Override
    public String toString() {
        return "Autor: " + nome + " (" + nascimento + " - " + falecimento + ")";
    }
}