# 📚 LiterAlura: Integração com API Gutendex

Este projeto é um sistema de catálogo de livros desenvolvido como parte da formação do curso e um  desafio proposto pela Alura e o programa Oracle Next Education (ONE). A aplicação realiza buscas na API Gutendex, processa os dados JSON e os armazena de forma estruturada em um banco de dados relacional.

## ⚙️ Funcionamento e Objetivos
A ideia foi construir uma ferramenta que não apenas buscasse dados externos, mas que também permitisse a gestão desses dados localmente. O sistema oferece:

* **Persistência de Dados:** Todos os livros e autores pesquisados são armazenados no PostgreSQL.
* **Consultas Inteligentes:** Filtros por idioma e listagem de autores que já passaram pela base de dados.
* **Interatividade via Console:** Uma interface simples para que o usuário navegue pelas opções de busca.

## 🚀 Decisões Técnicas
Para realizar o projeto, utilizei:
* **Java 17 & Spring Boot:** Base da aplicação para um desenvolvimento ágil e robusto.
* **Spring Data JPA:** Para facilitar a comunicação com o banco de dados e garantir a integridade dos registros.
* **Jackson:** Responsável por "traduzir" as respostas da API para o código Java.

## 💻 Como Utilizar
1. Faça o download ou clone este repositório do GitHub.
2. No seu ambiente, configure as credenciais do banco de dados no arquivo `application.properties`.
3. Execute a aplicação e utilize o menu exibido no terminal.
4. Certifique-se de que o PostgreSQL está rodando para que os dados sejam salvos corretamente.

---
**Desenvolvido por Valéria Aparecida Rodrigues Vieira**



