package com.alura.literalura;
import java.util.List;
import java.util.Scanner;
import java.util.Optional;
import com.alura.literalura.Autor;
import com.alura.literalura.Livro;
import com.alura.literalura.Dados;
import com.alura.literalura.DadosLivro;
import com.alura.literalura.LivroRepository;
import com.alura.literalura.AutorRepository;
import com.alura.literalura.ConverteDados;
import java.util.List;
import java.util.Scanner;

public class Cliente {
    private Scanner leitura = new Scanner(System.in);
    private Busca buscaApi = new Busca();
    private ConverteDados conversor = new ConverteDados();
    private String endereco = "https://gutendex.com/books/?search=";

    private LivroRepository livroRepo;
    private AutorRepository autorRepo;

    // Construtor: para o Cliente funcionar, ele precisa dos repositórios
    public Cliente(LivroRepository livroRepo, AutorRepository autorRepo) {
        this.livroRepo = livroRepo;
        this.autorRepo = autorRepo;
    }

    public void exibeMenu() {
        var opcao = -1;
        while (opcao != 0) {
            var menu = """
                    1 - Buscar livro pelo título
                    2 - Listar livros registrados
                    3 - Listar nossos autores
                    4 - Listar autores em determinado ano
                    5 - Listar livros em determinado idioma
                    0 - Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1 -> buscarLivroWeb();
                case 2 -> listarLivros();
                case 3 -> listarAutores();
                case 4 -> listarAutoresVivosNoAno();
                case 5 -> listarLivrosPorIdioma();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida");
            }
        }
    }

    private void buscarLivroWeb() {
        System.out.println("Digite o nome do livro para busca:");
        var nomeLivro = leitura.nextLine();
        var json = buscaApi.obterDados(endereco + nomeLivro.replace(" ", "%20"));

        // Usando o Jackson para ler a lista de resultados
        var dadosBusca = conversor.obterDados(json, Dados.class);

        if (dadosBusca.resultados().isEmpty()) {
            System.out.println("Livro não encontrado.");
        } else {
            DadosLivro dadosLivro = dadosBusca.resultados().get(0);

            // Regra do Trello: Salvar livro e autor no banco
            Autor autor = new Autor(dadosLivro.autor().get(0));
            // Verifica se o autor já existe para não duplicar
            var autorNoBanco = autorRepo.findByNomeContainingIgnoreCase(autor.getNome());

            if (autorNoBanco.isPresent()) {
                autor = autorNoBanco.get();
            } else {
                autor = autorRepo.save(autor);
            }

            Livro livro = new Livro(dadosLivro);
            livro.setAutor(autor);

            try {
                livroRepo.save(livro);
                System.out.println(livro);
            } catch (Exception e) {
                System.out.println("Erro: Livro já cadastrado no banco.");
            }
        }
    }

    private void listarLivros() {
        List<Livro> livros = livroRepo.findAll();
        livros.forEach(System.out::println);
    }

    private void listarAutores() {
        List<Autor> autores = autorRepo.findAll();
        autores.forEach(System.out::println);
    }

    private void listarAutoresVivosNoAno() {
        System.out.println("Digite o ano:");
        var ano = leitura.nextInt();
        List<Autor> autores = autorRepo.findByNascimentoLessThanEqualAndFalecimentoGreaterThanEqual(ano, ano);
        autores.forEach(System.out::println);
    }

    private void listarLivrosPorIdioma() {
        System.out.println("""
                Digite o idioma para busca:
                es - espanhol
                en - inglês
                fr - francês
                pt - português
                """);
        var idioma = leitura.nextLine();
        List<Livro> livros = livroRepo.findByIdioma(idioma);
        if (livros.isEmpty()) {
            System.out.println("Não existem livros nesse idioma no banco.");
        } else {
            livros.forEach(System.out::println);
        }
    }
}