# 📚 LiterAlura - Catálogo de Livros

Este projeto é um desafio de programação do programa **Oracle Next Education (ONE)** em parceria com a **Alura**. Uma aplicação Java que consome a API **Gutendex** para buscar informações sobre livros e autores, armazenando-os em um banco de dados relacional.

## 🚀 Funcionalidades
* **Busca de livros por título:** Consulta a API Gutendex e salva no banco de dados.
* **Listagem de livros:** Exibe todos os livros que já foram pesquisados e salvos.
* **Listagem de autores:** Exibe os autores dos livros registrados.
* **Filtro por idioma:** Permite buscar livros salvos de acordo com o idioma (ex: pt, en, fr).
* **Persistência de dados:** Utiliza PostgreSQL para manter os dados salvos.

## 🛠️ Tecnologias Utilizadas
* **Java 17**
* **Spring Boot**
* **Spring Data JPA**
* **PostgreSQL**
* **API Gutendex** (Jackson para manipulação de JSON)

## 📖 Como rodar o projeto
1. Clone o repositório.
2. Configure as credenciais do seu banco de dados PostgreSQL no arquivo `application.properties`.
3. Execute a classe `LiteraluraApplication`.
4. Use o menu interativo no console para navegar pelas opções.

---
Desenvolvido com ❤️ por **Valéria Aparecida Rodrigues Vieira**
