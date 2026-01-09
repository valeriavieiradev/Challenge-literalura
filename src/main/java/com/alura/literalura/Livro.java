package com.alura.literalura;

import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true) // Regra: não deixa salvar o mesmo título duas vezes
    private String titulo;

    private String idioma;
    private Integer downloads;

    @ManyToOne // Relacionamento: Muitos livros pertencem a um autor
    private Autor autor;

    // Construtor vazio (obrigatório)
    public Livro() {}

    // Construtor que transforma os dados da API em objeto de banco
    public Livro(DadosLivro dados) {
        this.titulo = dados.titulo();
        // O Trello sugeriu pegar apenas o primeiro idioma da lista
        this.idioma = !dados.idiomas().isEmpty() ? dados.idiomas().get(0) : "Desconhecido";
        this.downloads = dados.downloads();
    }

    // Getters e Setters (as chaves para acessar os dados)
    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getIdioma() { return idioma; }
    public Integer getDownloads() { return downloads; }
    public Autor getAutor() { return autor; }
    public void setAutor(Autor autor) { this.autor = autor; }

    @Override
    public String toString() {
        return "---------- LIVRO ----------" +
                "\nTítulo: " + titulo +
                "\nAutor: " + (autor != null ? autor.getNome() : "Desconhecido") +
                "\nIdioma: " + idioma +
                "\nDownloads: " + downloads +
                "\n---------------------------";
    }
}